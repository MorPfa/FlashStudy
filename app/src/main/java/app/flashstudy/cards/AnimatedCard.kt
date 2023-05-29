package app.flashstudy.cards

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.flashstudy.R

enum class BoxState { Front, Back }

private class TransitionData(
    rotation: State<Float>,
    animateFront: State<Float>,
    animateBack: State<Float>
) {
    val rotation by rotation
    val animateFront by animateFront
    val animateBack by animateBack
}


@Composable
fun AnimatingBox(
    rotated: Boolean,
    modifier: Modifier,
    onRotate: (Boolean) -> Unit

) {
    val transitionData = updateTransitionData(
        if (rotated) BoxState.Back else BoxState.Front
    )
    Card(
        Modifier
            .fillMaxWidth(.9f).
                fillMaxHeight(.5f)
            .graphicsLayer {
                rotationY = transitionData.rotation
                cameraDistance = 8 * density
            }
            .clickable { onRotate(!rotated) }, backgroundColor = MaterialTheme.colors.background

    )
    {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = if (rotated) stringResource(R.string.Placeholder_for_answer) else stringResource(R.string.Placeholder_for_question),
                modifier = Modifier
                    .graphicsLayer {
                        alpha =
                            if (rotated) transitionData.animateBack else transitionData.animateFront
                        rotationY = transitionData.rotation
                    })
        }

    }
}





@Composable
private fun updateTransitionData(boxState: BoxState): TransitionData {
    val transition = updateTransition(boxState, label = "")
    val rotation = transition.animateFloat(
        transitionSpec = {
            tween(500)
        },
        label = ""
    ) { state ->
        when (state) {
            BoxState.Front -> 0f
            BoxState.Back -> 180f
        }
    }

    val animateFront = transition.animateFloat(
        transitionSpec = {
            tween(500)
        },
        label = ""
    ) { state ->
        when (state) {
            BoxState.Front -> 1f
            BoxState.Back -> 0f
        }
    }
    val animateBack = transition.animateFloat(
        transitionSpec = {
            tween(500)
        },
        label = ""
    ) { state ->
        when (state) {
            BoxState.Front -> 0f
            BoxState.Back -> 1f
        }
    }

    return remember(transition) { TransitionData( rotation, animateFront, animateBack) }
}

@Preview(showBackground = true)
@Composable
fun AnimatingBoxPreview() {
    var rotated by remember { mutableStateOf(false) }
    AnimatingBox(rotated, modifier = Modifier) { rotated = it }
}