package com.ifancc.petadoption
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
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
                    LayoutsCodelab(onClick = {
                        navigate(Screen.PetDetail, Screen.PetList)
                    })
                }
            }
        }
    }
}
@Composable
fun LayoutsCodelab(onClick: (() -> Unit)? = null) {
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
    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            PetCard(onClick = onClick)
        }
    }

}
@Composable
fun PetCard(modifier: Modifier = Modifier,
            onClick: (() -> Unit)? = null ) {

    val catImagePainter = painterResource(id = R.drawable.cat1)
    Row(modifier = Modifier
        .clickable { onClick?.invoke()}
        .padding(8.dp)
        .fillMaxWidth()) {
        Surface(
            modifier = Modifier.height(120.dp),
            shape = RoundedCornerShape(5.dp),
            color = MaterialTheme.colors.onSurface.copy(0.2f)
        ) {
            Image(catImagePainter,
                contentDescription = "Cat Example"
            )
        }
        Surface(shape = RoundedCornerShape(5.dp),
            color = Color.Gray) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)

            ) {
                Text("Alfred Sisley", fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}
@Preview
@Composable
fun PhotographerCardPreview() {
    PetAdoptionTheme {
        LayoutsCodelab()
    }
}