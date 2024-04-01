package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.data.Wellness
import com.example.a30daysapp.data.wellnesses
import com.example.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of messages about wellness.
 */
@Composable
fun ThirtyDaysApp() {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(wellnesses) {
                WellnessItem(
                    wellness = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}



/**
 * Composable that displays a Top Bar with a text.
 *
 * @param modifier modifiers to set to this composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}


/**
 * Composable that displays a list item containing each day's wellness message.
 *
 * @param wellness contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun WellnessItem(
    wellness: Wellness,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                WellnessInformation(wellness.name, wellness.day)
                Spacer(Modifier.weight(1f))
                ArrowButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }

            WellnessImage(wellness.imageResourceId)
            if (expanded) {
                WellnessMessage(
                    wellness.text, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_small),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_small)
                    )
                )
            }
        }
    }
}
/**
 * Composable that displays a button that is clickable and displays an expand more or an expand less
 * icon.
 *
 * @param expanded represents whether the expand more or expand less icon is visible
 * @param onClick is the action that happens when the button is clicked
 * @param modifier modifiers to set to this composable
 */
@Composable
private fun ArrowButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


/**
 * Composable that displays a photo of the day.
 *
 * @param wellnessIcon is the resource ID for the image of the day
 * @param modifier modifiers to set to this composable
 */
@Composable
fun WellnessImage(
    @DrawableRes wellnessIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(wellnessIcon),

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

/**
 * Composable that displays a wellness's name and day.
 *
 * @param wellnessName is the resource ID for the string of the wellness's name
 * @param day is the Int that represents the day number
 * @param modifier modifiers to set to this composable
 */
@Composable
fun WellnessInformation(
    @StringRes wellnessName: Int,
    day: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.day, day),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(wellnessName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
        )
    }
}

/**
 * Composable that displays a wellness' message.
 *
 * @param wellnessMessage is the resource ID for the text string of the text to display
 * @param modifier modifiers to set to this composable
 */
@Composable
fun WellnessMessage(
    @StringRes wellnessMessage: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = stringResource(wellnessMessage),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysAppTheme {
//        Greeting("Android")
        ThirtyDaysApp()
    }
}