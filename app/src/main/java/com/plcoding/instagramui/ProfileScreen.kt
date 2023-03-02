package com.plcoding.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.plcoding.instagramui.ui.section.TopSection
import com.plcoding.instagramui.ui.section.button.ButtonSection
import com.plcoding.instagramui.ui.section.profile.ProfileSection
import com.plcoding.instagramui.ui.section.story.HighlightSection
import com.plcoding.instagramui.ui.section.story.StoryHighlight
import com.plcoding.instagramui.ui.section.tab.PostData
import com.plcoding.instagramui.ui.section.tab.PostSection
import com.plcoding.instagramui.ui.section.tab.PostTabView

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopSection(name = "abylay_kanayuly", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highLights = listOf(
                StoryHighlight(image = painterResource(id = R.drawable.youtube), text = "YouTube"),
                StoryHighlight(image = painterResource(id = R.drawable.qa), text = "Q&A"),
                StoryHighlight(image = painterResource(id = R.drawable.discord), text = "Discord"),
                StoryHighlight(image = painterResource(id = R.drawable.telegram), text = "Telegram")
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            data = listOf(
                PostData(image = painterResource(id = R.drawable.ic_grid), text = "Posts"),
                PostData(image = painterResource(id = R.drawable.ic_reels), text = "Reels"),
                PostData(image = painterResource(id = R.drawable.ic_igtv), text = "IGTV"),
                PostData(image = painterResource(id = R.drawable.profile), text = "Profile"),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}