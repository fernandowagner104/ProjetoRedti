package com.pucminas.projetodti.feature_resourcers.presentation.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pucminas.projetodti.R
import com.pucminas.projetodti.feature_resourcers.presentation.edit.components.ResourceInputText
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val nameResourceState = viewModel.resourceNameModel.value
    val brandState = viewModel.brandModel.value
    val qntState = viewModel.qntModel.value
    val featureResourceState = viewModel.featureResourceModel.value
    val obsState = viewModel.obsModel.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveResource -> {
                    navController.navigateUp()
                }
            }
        }
    }
    
    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = stringResource(id = R.string.add_resource)
            )
        },
        content = {
            EditContent(
                nameResource = nameResourceState.text,
                brand = brandState.text,
                qnt = qntState.text,
                featureResource = featureResourceState.text,
                obs = obsState.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            EditBottomBar(
                onInsertResource = { viewModel.onEvent(EditEvent.InsertResource) }
            )
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditContent(
    nameResource: String,
    brand: String,
    qnt: String,
    featureResource: String,
    obs: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        ResourceInputText(
            text = nameResource,
            hint = stringResource(id = R.string.nameResource),
            onTextChange = { onEvent(EditEvent.EnteredNameResource(it)) }
        )
        ResourceInputText(
            text = brand,
            hint = stringResource(id = R.string.brand),
            onTextChange = { onEvent(EditEvent.EnteredBrand(it)) }
        )
        ResourceInputText(
            text = qnt,
            hint = stringResource(id = R.string.qnt),
            onTextChange = { onEvent(EditEvent.EnteredQnt(it)) }
        )
        ResourceInputText(
            text = featureResource,
            hint = stringResource(id = R.string.featureResource),
            onTextChange = { onEvent(EditEvent.EnteredFeatureResource(it)) }
        )
        ResourceInputText(
            text = obs,
            hint = stringResource(id = R.string.obs),
            onTextChange = { onEvent(EditEvent.EnteredObs(it)) }
        )
    }
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertResource: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertResource() }
    ) {
        Text(text = stringResource(id = R.string.add_resource))
    }
}


