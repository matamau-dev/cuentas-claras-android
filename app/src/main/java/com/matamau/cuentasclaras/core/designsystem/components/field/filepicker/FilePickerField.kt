package com.matamau.cuentasclaras.core.designsystem.components.field.filepicker

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import coil3.compose.AsyncImage
import com.matamau.cuentasclaras.core.designsystem.theme.AppTheme
import java.io.File

private fun createReceiptUri(context: Context): Uri {
    val dir = File(context.cacheDir, "receipts").apply { mkdirs() }
    val file = File.createTempFile("receipt_", ".jpg", dir)
    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file,
    )
}

@Composable
fun FilePickerField(
    photos: List<String>,
    onPhotosChange: (List<String>) -> Unit,
    modifier: Modifier = Modifier,
    maxPhotos: Int = 3,
    label: String = "Adjuntar recibo",
) {
    val context = LocalContext.current

    var pendingUri by rememberSaveable { mutableStateOf<String?>(null) }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
    ) { success ->
        val uri = pendingUri
        if (success && uri != null) {
            onPhotosChange(photos + uri)
        }
        pendingUri = null
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            onPhotosChange(photos + uri.toString())
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
    ) {
        Text(
            text = "$label (${photos.size}/$maxPhotos)",
            style = AppTheme.typography.labelSmall,
            color = AppTheme.colors.onBackground.copy(alpha = 0.5f)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.md)
        ) {
            itemsIndexed(photos) { index, photo ->
                Box(
                    modifier = Modifier.size(88.dp)
                ) {
                    AsyncImage(
                        model = photo,
                        contentDescription = "Foto ${index + 1}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(AppTheme.shapes.medium)
                    )
                    IconButton(
                        onClick = { onPhotosChange(photos - photo) },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(28.dp)
                            .background(
                                color = AppTheme.colors.background,
                                shape = CircleShape
                            ),
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Quitar foto ${index + 1}",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            if (photos.size < maxPhotos) {
                item {
                    AddPhotoTile(
                        icon = Icons.Filled.AddPhotoAlternate,
                        description = "Elegir de la galería",
                        onClick = {
                            galleryLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                    )
                }
                item {
                    AddPhotoTile(
                        icon = Icons.Filled.CameraAlt,
                        description = "Tomar foto",
                        onClick = {
                            val uri = createReceiptUri(context)
                            pendingUri = uri.toString()
                            cameraLauncher.launch(uri)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun AddPhotoTile(
    icon: ImageVector,
    description: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(88.dp)
            .clip(AppTheme.shapes.medium)
            .border(1.dp, AppTheme.colors.outline, AppTheme.shapes.medium)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = AppTheme.colors.onSurfaceVariant,
        )
    }
}