package com.davidnardya.payplustest.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.davidnardya.payplustest.R
import com.davidnardya.payplustest.models.BillingEntryHeader
import com.davidnardya.payplustest.navigation.Screen
import com.davidnardya.payplustest.viewmodels.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(viewModel: MainViewModel, navController: NavHostController) {
    val billingState = viewModel.billingHeaderLiveData.observeAsState()
    var list by remember { mutableStateOf(listOf<BillingEntryHeader>()) }

    LaunchedEffect(billingState) {
        billingState.value?.headers?.let {
            list = it.toMutableList()
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        if (list.isNotEmpty()) {
            LazyColumn {
                itemsIndexed(list) { index, item ->
                    val clip = when (index) {
                        0 -> {
                            RoundedCornerShape(topEnd = 6.dp, topStart = 6.dp)
                        }

                        list.lastIndex -> {
                            RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                        }

                        else -> {
                            RoundedCornerShape(0.dp)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .shadow(elevation = 6.dp)
                            .clickable {
                                item.id?.toLong()?.let {
                                    navController.navigate(Screen.BillingEntry.route)
                                    viewModel.getBillingDetails(it)
                                }
                            }
                            .clip(clip),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        Column {
                            Image(imageVector = Icons.Default.Add, contentDescription = "")
                            Text(text = item.price.toString())
                            Row(
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = SimpleDateFormat(
                                        "dd-MM-yyyy HH:mm",
                                        Locale.ENGLISH
                                    ).format(
                                        Date(item.created?.toLong() ?: 0)
                                    )
                                )
                                Text(text = item.entryNumber.toString())
                            }
                        }
                        Column {
                            Row {
                                Image(
                                    painter = if (item.currencyCode?.lowercase() == "usd") {
                                        painterResource(id = R.drawable.ic_dollar)
                                    } else {
                                        painterResource(id = R.drawable.ic_ils)
                                    }, contentDescription = "Currency"
                                )
                                Image(
                                    imageVector = Icons.Default.ArrowBackIosNew,
                                    contentDescription = "ToItem"
                                )
                            }
                        }
                    }
                }
            }
        } else {
            Text(text = "Loading")
        }
    }


}