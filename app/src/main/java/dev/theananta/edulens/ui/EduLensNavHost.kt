package dev.theananta.edulens.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import dev.theananta.edulens.data.students
import dev.theananta.edulens.data.universitiesInVizag
import dev.theananta.edulens.home.HomePage
import dev.theananta.edulens.home.course.Course
import dev.theananta.edulens.home.course.CoursePage
import dev.theananta.edulens.model.University
import dev.theananta.edulens.ui.onboarding.AuthenticationPage
import dev.theananta.edulens.ui.onboarding.LoginPage
import dev.theananta.edulens.ui.onboarding.UniversitySelectionPage
import dev.theananta.edulens.ui.profile.ProfilePage

enum class EduLensRoute(val route: String) {
    UNIVERSITY_SELECTION("/university_selection"),
    AUTHENTICATION("/auth"),
    LOGIN("/login"),
    HOME("/home"),
    PROFILE("/profile"),
    COURSE("/course")
}

@Composable
fun EduLensNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val onScanQRCode = { context: Context ->
        val options = GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                Barcode.FORMAT_QR_CODE
            )
            .enableAutoZoom()
            .build()

        val scanner = GmsBarcodeScanning.getClient(context, options)
        scanner.startScan().addOnSuccessListener { barcode ->
            if (barcode.rawValue != null) {
                val user = students.first { it.rollNumber == barcode.rawValue }
                navController.navigate(EduLensRoute.HOME.route + "/${user.rollNumber}")
            }
        }.addOnCanceledListener {
//                    bluetoothViewModel.resolveError("Scanning cancelled")
        }.addOnFailureListener { result ->
//                    bluetoothViewModel.resolveError(result.localizedMessage)
        }
    }
    NavHost(
        navController = navController,
        startDestination = EduLensRoute.UNIVERSITY_SELECTION.route
    ) {
        composable(route = EduLensRoute.UNIVERSITY_SELECTION.route) {
            var selectedUniversity by remember {
                mutableStateOf<University?>(null)
            }
            UniversitySelectionPage(
                modifier = modifier,
                universities = universitiesInVizag,
                selectedUniversity = selectedUniversity
            ) { university ->
                selectedUniversity = university
                navController.navigate(EduLensRoute.AUTHENTICATION.route + "/${university.id}")
            }
        }
        composable(route = EduLensRoute.AUTHENTICATION.route + "/{universityId}",
            arguments = listOf(
                navArgument("universityId") {
                    type = NavType.StringType
                }
            )) { navbackStackEntry ->
            val context = LocalContext.current
            val university =
                universitiesInVizag.first { it.id == navbackStackEntry.arguments?.getString("universityId") }
            AuthenticationPage(university = university, onScanId = {
                onScanQRCode(context)
            }, navigateToSignUp = {
                navController.navigate(EduLensRoute.LOGIN.route + "/${university.id}")
            })
        }
        composable(
            EduLensRoute.LOGIN.route + "/{universityId}",
            arguments = listOf(
                navArgument("universityId") {
                    type = NavType.StringType
                }
            )) { navbackStackEntry ->
            val context = LocalContext.current
            val university =
                universitiesInVizag.first { it.id == navbackStackEntry.arguments?.getString("universityId") }
            LoginPage(university = university, onScanId = {
                onScanQRCode(context)
            }, onSignUp = { email, password ->
                navController.navigate(EduLensRoute.HOME.route + "/${students.first().rollNumber}")
                //TODO: Renable condition
//                val filteredStudent = students.filter {
//                    email.trim() == it.email
//                }
//                Log.e("ERROR", (filteredStudent.firstOrNull()?.rollNumber == password.trim()).toString())
//                if (filteredStudent.isNotEmpty() && filteredStudent.first().rollNumber == password) {
//                    navController.navigate(EduLensRoute.HOME.route + "/${filteredStudent.first().rollNumber}")
//                } else {
//                    //Handle error
//                    Log.d("USERNAME", email)
//                    Log.d("Password", password)
//                    Log.e("ERROR", filteredStudent.toString())
//                }
            })
        }
        composable(
            EduLensRoute.HOME.route + "/{userId}", arguments = listOf(
            navArgument("userId") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            val user =
                students.firstOrNull { it.rollNumber == navBackStackEntry.arguments?.getString("userId") }
                    ?: students.get(2)

            HomePage(user = user, modifier = modifier, navigateToCourse = { courseId ->
                navController.navigate(EduLensRoute.COURSE.route + "/${courseId}")
            }) {
                navController.navigate(EduLensRoute.PROFILE.route + "/${user.rollNumber}")
            }

        }
        composable(
            EduLensRoute.PROFILE.route + "/{userId}", arguments = listOf(
            navArgument("userId") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            val user =
                students.firstOrNull { it.rollNumber == navBackStackEntry.arguments?.getString("userId") }
                    ?: students.get(2)

            ProfilePage(user = user)

        }

        composable(
            EduLensRoute.COURSE.route + "/{courseId}", arguments = listOf(
                navArgument("courseId") {
                    type = NavType.StringType
                }
            )) { navBackStackEntry ->
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
            val course =
                courses.firstOrNull { it.courseId == navBackStackEntry.arguments?.getString("courseId") }
                    ?: courses.get(0)

            CoursePage(course = course){
                navController.navigateUp()
            }

        }
    }
}