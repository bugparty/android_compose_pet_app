package com.ifancc.petadoption
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifancc.petadoption.ui.theme.PetAdoptionTheme
class PetDetailFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            this.id = R.id.pet_detail_fragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                PetAdoptionTheme {
                    PetDetail(onBack = {
                        navigate(Screen.PetList, Screen.PetDetail)
                    })
                }
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