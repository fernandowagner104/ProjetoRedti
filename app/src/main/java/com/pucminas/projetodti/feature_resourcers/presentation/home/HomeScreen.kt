package com.pucminas.projetodti.feature_resourcers.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pucminas.projetodti.R
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.presentation.Screen
import com.pucminas.projetodti.feature_resourcers.presentation.home.components.UserItem
import com.pucminas.projetodti.ui.theme.RedtiAppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = { navController.navigate(Screen.Edit.route) }
            )
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteResource = { viewModel.onEvent(HomeEvent.DeleteResource(it)) },
                onEditResource = {
                    navController.navigate(
                        route = Screen.Edit.passId(it)
                    )
                },
                resources = state.resources
            )
        }
    )
}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.resources),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteResource: (resource: Resource) -> Unit,
    onEditResource: (id: Int?) -> Unit,
    resources: List<Resource> = emptyList()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(resources) { resource ->
                UserItem(
                    resource = resource,
                    onEditResource = { onEditResource(resource.id) },
                    onDeleteResource = { onDeleteResource(resource) }
                )
            }
        }
    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {  }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_resource))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserContent() {
    RedtiAppTheme(darkTheme = false) {
        HomeContent(onDeleteResource = {}, onEditResource = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserFab() {
    RedtiAppTheme(darkTheme = false) {
        HomeFab()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserTopBar() {
    RedtiAppTheme(darkTheme = false) {
        HomeTopBar()
    }
}

