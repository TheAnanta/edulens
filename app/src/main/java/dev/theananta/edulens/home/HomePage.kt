package dev.theananta.edulens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.DesignServices
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.WifiFind
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import dev.theananta.edulens.data.students
import dev.theananta.edulens.home.course.CoursesPage
import dev.theananta.edulens.home.dashboard.DashboardPage
import dev.theananta.edulens.model.User
import dev.theananta.edulens.ui.EduLensLogo
import dev.theananta.edulens.ui.theme.EduLensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    user: User = students.first(),
    navigateToCourse: (String) -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    var currentBackStack by remember {
        mutableStateOf(0)
    }
    Scaffold(topBar = {
        TopAppBar(title = {
            EduLensLogo()
        }, actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Rounded.WifiFind, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Rounded.NotificationsNone, contentDescription = null)
            }
            IconButton(onClick = navigateToProfile) {
                Icon(Icons.Rounded.AccountCircle, contentDescription = null)
                when (user) {
                    is User.Student -> AsyncImage(
                        model = user.image,
                        contentDescription = null,
                    )
                }
            }
        })
    }, bottomBar = {
        NavigationBar {
            NavigationBarItem(selected = currentBackStack == 0, label = {
                Text("Dashboard")
            }, onClick = {
                currentBackStack = 0
            }, icon = {
                Icon(Icons.Rounded.Home, contentDescription = null)
            })
            NavigationBarItem(selected = currentBackStack == 1, label = {
                Text("Courses")
            }, onClick = {
                currentBackStack = 1
            }, icon = {
                Icon(Icons.Rounded.Book, contentDescription = null)
            })
            NavigationBarItem(selected = currentBackStack == 2, label = {
                Text("Calendar")
            }, onClick = {
                currentBackStack = 2
            }, icon = {
                Icon(Icons.Rounded.CalendarMonth, contentDescription = null)
            })
            NavigationBarItem(selected = currentBackStack == 3, label = {
                Text("G-Services")
            }, onClick = {
                currentBackStack = 3
            }, icon = {
                Icon(Icons.Rounded.DesignServices, contentDescription = null)
            })
        }
    }) { innerPadding ->
        when (currentBackStack) {
            0 -> when(user){
                is User.Student -> DashboardPage(modifier = modifier.padding(innerPadding), student = user)
            }
            1 -> CoursesPage(
                modifier = modifier.padding(innerPadding),
                navigateToCourse = navigateToCourse
            )

            2 -> CalendarPage(modifier = modifier.padding(innerPadding))
            3 -> GServicesPage(modifier = modifier.padding(innerPadding))
        }
    }
}


@Composable
fun CalendarPage(modifier: Modifier = Modifier) {

}

@Composable
fun GServicesPage(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun HomePagePreview() {
    EduLensTheme {
        HomePage()
    }
}