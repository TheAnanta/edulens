package dev.theananta.edulens.home.course

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.theananta.edulens.ui.theme.EduLensTheme
import java.util.Calendar


@Composable
fun CoursesPage(modifier: Modifier = Modifier, navigateToCourse: (String) -> Unit = {}) {
    var selectedTab by remember {
        mutableStateOf("Time Table")
    }
    val tabs = listOf("Time Table", "Enrolled Courses")
    Column(modifier = modifier) {
        TabRow(selectedTabIndex = tabs.indexOf(selectedTab)) {
            tabs.forEach { tabName ->
                Tab(selected = selectedTab == tabName, onClick = {
                    selectedTab = tabName
                }, text = {
                    Text(tabName)
                })
            }
        }
        when (selectedTab) {
            "Time Table" -> TimeTablePage()
            else -> EnrolledCoursesPage(navigateToCourse = navigateToCourse)
        }

    }
}

data class Course(
    val name: String,
    val courseId: String,
    val attendence: Float,
    val description: String,
    val time: String,
    val amOrPm: Boolean = true,
    val classRoomNumber: String = "318",
    val quizzes: List<String> = listOf(),
    val assignments: List<String> = listOf(),
    val materials: List<String> = listOf(),
)

@Composable
fun TimeTablePage(modifier: Modifier = Modifier) {
    var selectedDay by remember {
        mutableStateOf(Calendar.getInstance().time.day)
    }
    val timeTable = listOf(
        listOf(
            Course("Software Engineering", "CSEN1131", 0.85f, description = "", time = "08:00"),
            Course(
                "Database Management Systems",
                "CSEN2061",
                0.85f,
                description = "",
                time = "09:00"
            ),
            Course(
                "Design and Analysis of Algorithms",
                "CSEN3001",
                0.85f,
                description = "",
                time = "10:00"
            ),
            Course("Artificial Neural Networks", "CSEN2151", 0.85f, description = "", "11:00"),
            Course(
                "Operations Management",
                "OPMG2001",
                0.85f,
                description = "",
                "12:00",
                amOrPm = false
            ),
            Course(
                "Software Engineering Lab",
                "CSEN1131P",
                0.85f,
                description = "",
                time = "02:00",
                amOrPm = false
            )
        ),
        listOf(
            Course(
                "Database Management Systems Lab",
                "CSEN3001P1",
                0.85f,
                description = "",
                time = "08:00"
            ), Course(
                "Design and Analysis of Algorithms",
                "CSEN3001",
                0.85f,
                description = "",
                time = "10:00"
            ),
            Course(
                "Formal Language And Automata Theory",
                "CSEN2041",
                0.85f,
                description = "",
                "11:00"
            ),
            Course(
                "Artificial Neural Networks Lab",
                "CSEN2151P",
                0.85f,
                description = "",
                time = "02:00",
                amOrPm = false
            )
        ),
        listOf(

            Course(
                "Database Management Systems",
                "CSEN2061",
                0.85f,
                description = "",
                time = "08:00"
            ),
            Course(
                "Formal Language And Automata Theory",
                "CSEN2041",
                0.85f,
                description = "",
                "09:00"
            ),
            Course("Software Engineering", "CSEN1131", 0.85f, description = "", time = "10:00"),
            Course(
                "Design and Analysis of Algorithms",
                "CSEN3001",
                0.85f,
                description = "",
                time = "11:00"
            ),
            Course("Operations Management", "CSEN2151", 0.85f, description = "", "12:00"),

            )
    )
    Column(modifier = modifier) {
        TimeTableWeekList(
            modifier = Modifier.padding(vertical = 16.dp),
            selectedDay = selectedDay
        ) {
            selectedDay = it
        }
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(timeTable.get(selectedDay % 3)) { course ->
                Card {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text("ICT")
                                Text(
                                    course.classRoomNumber,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 16.dp, vertical = 6.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    course.courseId,
                                    style = MaterialTheme.typography.labelLarge,
                                )
                                Text(
                                    course.name,
                                    style = MaterialTheme.typography.titleLarge,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(course.time, style = MaterialTheme.typography.titleLarge)
                                Text(if (course.amOrPm) "AM" else "PM")
                            }
                        }
                        LinearProgressIndicator(
                            progress = { course.attendence },
                            modifier = Modifier.padding(top = 6.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TimeTableWeekList(
    modifier: Modifier = Modifier,
    selectedDay: Int = 0,
    onSelectDate: (Int) -> Unit = {}
) {
    LazyRow(modifier = modifier) {
        items(5) {
            val newCalendar = Calendar.getInstance()
            newCalendar.add(Calendar.HOUR, 24 * (it))
            Text(
                newCalendar.time.date.toString(),
                color = if (selectedDay == newCalendar.time.day) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onSelectDate(newCalendar.time.day)
                    }
                    .clip(CircleShape)
                    .background(if (selectedDay == newCalendar.time.day) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer)
                    .padding(4.dp)
                    .size(32.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
private fun TimeTablePagePreview() {
    EduLensTheme {
        TimeTablePage()
    }
}

@Composable
fun EnrolledCoursesPage(modifier: Modifier = Modifier, navigateToCourse: (String) -> Unit = {}) {
    val courses = listOf(
        Course("Software Engineering", "CSEN1131", 0.85f, description = "", time = "08:00"),
        Course(
            "Database Management Systems",
            "CSEN2061",
            0.85f,
            description = "",
            time = "09:00"
        ),
        Course(
            "Design and Analysis of Algorithms",
            "CSEN3001",
            0.85f,
            description = "",
            time = "10:00"
        ),
        Course("Artificial Neural Networks", "CSEN2151", 0.85f, description = "", "11:00"),
        Course(
            "Operations Management",
            "OPMG2001",
            0.85f,
            description = "",
            "12:00",
            amOrPm = false
        )
    )
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(courses) { course ->
            Card {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp, vertical = 6.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                course.courseId,
                                style = MaterialTheme.typography.labelLarge,
                            )
                            Text(
                                course.name,
                                style = MaterialTheme.typography.titleLarge,
                            )
                        }
                        IconButton(onClick = {
                            navigateToCourse(course.courseId)
                        }) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                        }
                    }
                    LinearProgressIndicator(
                        progress = { course.attendence },
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun EnrolledCoursesPagePreview() {
    EduLensTheme {
        EnrolledCoursesPage()
    }
}

@Preview
@Composable
fun CoursesPagePreview(modifier: Modifier = Modifier) {
    EduLensTheme {
        CoursesPage()
    }
}