package com.ifancc.petadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifancc.petadoption.ui.theme.PetAdoptionTheme

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetAdoptionTheme {
                PetDetail(onBack = {
                    finish()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetDetail(onBack:(()->Unit)?= null) {
    PetAdoptionTheme {
        val catImagePainter = painterResource(id = R.drawable.cat1)
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "Pet Adaption Detail")
            },navigationIcon={
                IconButton(onClick = {onBack?.invoke()}) {
                    Icon(imageVector = Icons.Filled.ArrowBack,"back")
                }
            })

        }) { innerPadding ->
            Column {
                Image(
                    painter = catImagePainter, contentScale = ContentScale.Crop,
                    contentDescription = "backgroud",
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                )
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Column {
                        Text("Pastal", fontSize = 28.sp)
                        Row(
                            modifier = Modifier.padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("origin: Mexico")
                            Spacer(modifier = Modifier.width(120.dp))
                            Text("three years old")
                        }
                    }

                }

            }
        }

    }
}