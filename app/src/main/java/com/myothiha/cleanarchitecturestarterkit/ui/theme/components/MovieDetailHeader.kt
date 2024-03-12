package com.myothiha.cleanarchitecturestarterkit.ui.theme.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myothiha.cleanarchitecturestarterkit.R

/**
 * @Author myothiha
 * Created 11/03/2024 at 9:19 PM.
 **/

@Composable
fun MovieDetailHeader(
    modifier: Modifier = Modifier,
    state: MovieDetailScreenScrollState = rememberMovieDetailScreenScrollState()
) {
    AnimatedVisibility(
        visible = state.isSheetScrolled.not(),
        enter = fadeIn(
            animationSpec = tween(
                500,
                delayMillis = 50,
                easing = FastOutLinearInEasing
            )
        ),
        exit = fadeOut(
            animationSpec = tween(
                1000,
                delayMillis = 500,
                easing = EaseInOut
            )
        )
    ) {
        Row(
            modifier = modifier
                .height(225.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.harry_potter),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailHeaderPreview() {
    MovieDetailHeader(
        modifier = Modifier.fillMaxWidth(),
        state = rememberMovieDetailScreenScrollState()
    )
}