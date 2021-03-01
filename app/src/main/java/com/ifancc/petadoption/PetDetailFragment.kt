package com.ifancc.petadoption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.ifancc.petadoption.ui.theme.PetAdoptionTheme

class PetDetailFragment : Fragment() {
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


@Composable
fun PetDetail(onBack: (() -> Unit)? = null) {
    PetAdoptionTheme {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "Pet Adaption Detail")
            }, navigationIcon = {
                IconButton(onClick = { onBack?.invoke() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, "back")
                }
            })
        }) { innerPadding ->
            PetDetail()
        }
    }
}
fun Modifier.marginTop(top:Dp)=Modifier.layout{
        measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // Height of the composable with padding - first baseline
    val placeableY = top.roundToPx()
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
}

@Preview(showBackground = true)
@Composable
fun PetDetail(){
    val catImagePainter = painterResource(id = R.drawable.cat1)
    Box (Modifier.fillMaxSize()){
        Image(
            painter = catImagePainter, contentScale = ContentScale.Crop,
            contentDescription = "backgroud",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        )
        Box(modifier = Modifier.marginTop(260.dp)
        ){
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(25.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Column(modifier=Modifier.padding(horizontal = 10.dp)) {
                        Text("Pastal", fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.PetName),modifier = Modifier.padding(8.dp))
                        Box(modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth() ){

                            Text("origin: Mexico",
                                color= colorResource(id = R.color.GreyTextColor),
                                modifier = Modifier.align(Alignment.TopStart))

                            Text("three years old",
                                color= colorResource(id = R.color.GreyTextColor),
                                modifier = Modifier.align(Alignment.TopEnd))
                        }
                        Row(modifier = Modifier.padding(8.dp)) {
                            Icon(imageVector = Icons.Filled.LocationOn,"location",
                            tint = colorResource(id = R.color.GreyTextColor))
                            Text("93 shoreline Dr.Sr Carthlines",
                                color= colorResource(id = R.color.GreyTextColor),
                                modifier = Modifier.padding(start=8.dp))
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 20.dp)) {
                    Row{
                        Surface(modifier = Modifier.size(55.dp),
                            shape = CircleShape,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)) {
                            val userIcon = painterResource(id = R.drawable.erlich_backman)
                            Image(painter = userIcon,"user")
                        }
                        Column(modifier = Modifier.padding(start=8.dp)){
                            Text("John Williams", color= colorResource(id = R.color.OwnerNameColor))
                            Text("Owner",color= colorResource(id = R.color.OwnerTextColor))
                        }
                    }
                    Text("No commovida obrigacao le hypocrita tu os. Curtos ler casado mereca esposo nem avisar hombro cha. Es inspirar no pontapes condicao.",
                        color= colorResource(id = R.color.GreyTextColor))
                    Row(Modifier.padding(vertical = 8.dp)){
                        Button(onClick = {},Modifier.size(45.dp),
                        shape= RoundedCornerShape(15.dp)){
                            Icon(imageVector = Icons.Filled.FavoriteBorder,"like")
                        }
                        Button(onClick = {},
                            colors= ButtonDefaults.buttonColors(backgroundColor = colorResource(
                            id = R.color.PinkButton
                        )),
                           modifier = Modifier
                               .height(45.dp).fillMaxWidth()
                               .padding(start = 50.dp)){
                            Text("adoption")
                        }
                    }
                }
            }
        }
    }
}