package com.example.excompose.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.excompose.R
import com.example.excompose.profile_screen.model.StoryHighlight
import com.example.excompose.ui.theme.Shapes
import java.nio.file.WatchEvent

@Composable
fun ProfileScreen() {
    Column(Modifier.fillMaxSize()) {
        TopBar(
            name = "mostafagad_official",
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(22.dp))
        buttonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(22.dp))
        HighlightSection(
            highlights = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )

    }
}

@Composable
private fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Color.Black
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "notifications",
            tint = Color.Black
        )
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "menu",
            tint = Color.Black
        )
    }
}

@Composable
private fun ProfileSection(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.philipp),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            stateSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            name = "Programming Mentor",
            description = "10 years of coding experience\n" +
                    "Want me to make your app? Send me an email!\n" +
                    "Subscribe to my YouTube channel!",
            url = "https://youtube.com/c/mostafagad",
            followedBy = listOf("threads", "leo messi"),
            others = 17
        )
    }
}

@Composable
private fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = "round image",
        modifier = modifier
            .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun stateSection(modifier: Modifier = Modifier){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        ProfileState(numberText = "601", text = "Posts")
        ProfileState(numberText = "100K", text = "Followers")
        ProfileState(numberText = "72", text = "Following")
    }
}

@Composable
private fun ProfileState(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(text = text)
    }
}

@Composable
private fun ProfileDescription(
    name: String,
    description: String,
    url: String,
    followedBy: List<String>,
    others: Int
){
    val lineHeight = 16.sp
    val letterSpacing = 0.5.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp)
    ){
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = description,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if(index < followedBy.size - 1){
                        append(",")
                    }
                }
                if(others > 2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$others others")
                }
            },
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
    }
}

@Composable
private fun buttonSection(
    modifier: Modifier = Modifier
){
    val minWidth = 90.dp
    val height = 32.dp

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.height(height)
        )
    }
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = Shapes.small
            )
            .padding(6.dp)
    ){
        if(text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = "arrow down",
                tint = Color.Black
            )
        }
    }

}

@Composable
private fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
){
    LazyRow(
        modifier = modifier
    ){
        items(highlights){ highlight ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                RoundImage(
                    image = highlight.image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlight.text,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun PostTabView(
    modifier: Modifier = Modifier
){

}