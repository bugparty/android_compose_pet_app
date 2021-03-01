package com.ifancc.petadoption
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifancc.petadoption.ui.theme.PetAdoptionTheme

class PetListFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            this.id = R.id.pet_list_fragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                PetAdoptionTheme {
                    PetList(onClick = {
                        navigate(Screen.PetDetail, Screen.PetList)
                    })
                }
            }
        }
    }
}
@Composable
fun PetList(onClick: (() -> Unit)? = null) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Pet Adaption App")
        })

    }) { innerPadding ->
        PetCardList(Modifier.padding(innerPadding), onClick = onClick)
    }
}
@Composable
fun PetCardList(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null){
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .background(colorResource(id = R.color.background_grey))
            .padding(horizontal = 40.dp),
        horizontalAlignment = CenterHorizontally
            ) {
        repeat(100) {
            PetCard(onClick = onClick)
        }
    }

}
@Preview
@Composable
fun PetCard(modifier: Modifier = Modifier,
            onClick: (() -> Unit)? = null ) {

    val catImagePainter = painterResource(id = R.drawable.cat1)
    Row(modifier = Modifier
        .clickable { onClick?.invoke() }
        .padding(8.dp)
        .fillMaxWidth()) {
        Surface(
            modifier = Modifier
                .height(160.dp)
                .width(140.dp),
            shape = RoundedCornerShape(15.dp),
            color = MaterialTheme.colors.onSurface.copy(0.2f)
        ) {
            Image(catImagePainter,
                contentDescription = "Cat Example",
                contentScale= ContentScale.Crop
            )
        }
        Box(modifier = Modifier.height(160.dp),
            contentAlignment = Center
        ){
            Surface(
                shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp),
                color = Color.White) {
                Column(
                    modifier = Modifier
                        .padding(20.dp),


                ) {
                    Text("Pastel", fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.PetName))
                    Text("Cat", style = MaterialTheme.typography.body2,
                    color = colorResource(id = R.color.GreyTextColor))
                    Text("3 years old",
                        color = colorResource(id = R.color.GreyTextColor))
                    Row{
                        Icon(imageVector = Icons.Filled.LocationOn,"location",
                            tint = colorResource(id = R.color.GreyTextColor))
                        Text("93 shoreline",
                            color= colorResource(id = R.color.GreyTextColor),
                            modifier = Modifier.padding(start=8.dp))
                    }
                }
            }
        }

    }
}

@Composable
fun PhotographerCardPreview() {
    PetAdoptionTheme {
        PetList()
    }
}