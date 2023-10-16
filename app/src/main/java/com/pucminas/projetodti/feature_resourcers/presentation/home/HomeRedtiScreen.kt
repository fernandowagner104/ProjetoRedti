package com.pucminas.projetodti.feature_resourcers.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AddChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pucminas.projetodti.feature_resourcers.presentation.Screen

@Composable
fun HomeRedtiScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        contentColor = Color.Blue
    ) {
        Column(
            modifier = Modifier.padding(16.dp,top = 8.dp)

        ) {
            MenuBar()

            Spacer(modifier = Modifier.height(200.dp))

            OptionSection(navController)
        }
    }
}

// Composable que mostra os botões, contendo as opções de acesso
@Composable
fun OptionSection(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonAddResource(navController)
            ButtonListResource()
            ButtonReportResource()

        }

    }
}

@Composable
fun MenuBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )  {
        Text(text = "redti",  style = MaterialTheme.typography.h5)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Menu , contentDescription = "Menu de opções" )
        }
    }
}

// Button Home add Screen
@Composable
fun ButtonAddResource(navController: NavController) {
    Button(
        onClick = { navController.navigate(Screen.Home.route) },
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.elevation(16.dp)

    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "Cadastro",
            modifier = Modifier.size(ButtonDefaults.IconSize),

            tint = Color.Blue
        )
        //Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Spacer(modifier = Modifier.height(16.dp))
        Text("Cadastro")
    }
}

// Button List Screen
@Composable
fun ButtonListResource() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.elevation(16.dp)

    ) {
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Listagem",
            modifier = Modifier.size(ButtonDefaults.IconSize),

            tint = Color.Blue
        )
        //Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Spacer(modifier = Modifier.height(8.dp))
        Text("Listagem")
    }
}

// Button Report Screen
@Composable
fun ButtonReportResource() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.elevation(5.dp)

    ) {
        Icon(
            Icons.Rounded.AddChart,
            contentDescription = "Relatório",
            modifier = Modifier.size(ButtonDefaults.IconSize),

            tint = Color.Blue
        )
        //Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Spacer(modifier = Modifier.height(8.dp))
        Text("Relatório")
    }
}










