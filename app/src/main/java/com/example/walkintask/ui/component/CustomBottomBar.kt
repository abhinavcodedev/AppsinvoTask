package com.example.walkintask.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkintask.R
import com.example.walkintask.model.BottomNavItem
import com.example.walkintask.ui.theme.PrimaryColor
import com.example.walkintask.ui.theme.WalkInTaskTheme
import com.example.walkintask.ui.theme.WalkInTypography

@Composable
fun CustomBottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = remember {
        listOf(
            BottomNavItem(R.drawable.vector_smart_object_5, "My Booking"),
            BottomNavItem(R.drawable.vector_smart_object_8, "Scan QR"),
            BottomNavItem(R.drawable.vector_smart_object_copy_3_2, "Home"),
            BottomNavItem(R.drawable.shape_1, "My QR"),
            BottomNavItem(R.drawable.ic_profile, "Profile")
        )
    }

    val density = LocalDensity.current

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)  // barHeight(60) + fabRaise(28)
    ) {
        val itemWidth = maxWidth / items.size

        // ✅ FIX: Animated offset ab FAB ke liye use hoga
        val animatedOffset = remember { Animatable(0f) }
        LaunchedEffect(selectedIndex) {
            animatedOffset.animateTo(
                targetValue = with(density) { (itemWidth * selectedIndex).toPx() },
                animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing)
            )
        }

        // ─── 1. White bar (sirf bottom 60dp) ─────────────────────
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
        ) {
            drawRect(color = Color.White)
            // ✅ FIX: drawCircle REMOVE kiya — woh blue blob ban raha tha
            drawLine(
                color = Color(0xFFEEEEEE),
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 1.5f
            )
        }

        // ─── 2. Nav items Row ─────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { onItemSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    // Selected item ka icon FAB mein show hoga — yahan sirf label
                    if (!isSelected) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.title,
                            tint = Color(0xFFBBBBBB),
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(Modifier.height(4.dp))
                    }
                    Text(
                        text = item.title,
                        fontSize = 10.sp,
                        color = if (isSelected) PrimaryColor else Color(0xFF999999)
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
        }

        // ─── 3. Animated floating FAB ─────────────────────────────
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                // ✅ FIX: Animated offset use — smooth animation
                .offset(x = with(density) { animatedOffset.value.toDp() })
                .width(itemWidth)
                .height(60.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 2.dp)  // shadow ke liye thoda space
                    .size(56.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        ambientColor = PrimaryColor.copy(alpha = 0.3f),
                        spotColor = PrimaryColor.copy(alpha = 0.3f)
                    )
                    .background(PrimaryColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(items[selectedIndex].icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}