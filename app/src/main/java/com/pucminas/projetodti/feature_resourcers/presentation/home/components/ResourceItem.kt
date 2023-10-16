package com.pucminas.projetodti.feature_resourcers.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource

@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    resource: Resource,
    onEditResource: () -> Unit,
    onDeleteResource: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Material: ${resource.resourceName}",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Marca: ${resource.brand}",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Característica: ${resource.featureResource}",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Obs: ${resource.obs}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text ="Qnt: "+ resource.qnt.toString(),
                    style = MaterialTheme.typography.h6.copy(color = Color.DarkGray)
                )
            }
            Row {
                IconButton(onClick = onEditResource) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = Color.Blue
                    )
                }
                IconButton(onClick = onDeleteResource) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

