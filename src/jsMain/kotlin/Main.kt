import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        var currentPage by remember { mutableStateOf("home") }

        when (currentPage) {
            "home" -> HomePage { currentPage = it }
            "contact" -> ContactPage { currentPage = it }
            "privacy" -> PrivacyPage { currentPage = it }
            "order_form" -> OrderFormPage { currentPage = it }
            "order_success" -> OrderSuccessPage { currentPage = it }
        }
    }
}

@Composable
fun HomePage(navigateTo: (String) -> Unit) {
    Div {
        H1 { Text("Welcome to our Store!") }
        Button(attrs = {
            onClick { navigateTo("order_form") }
        }) {
            Text("Buy Product")
        }
        NavButtons(navigateTo)
    }
}

@Composable
fun ContactPage(navigateTo: (String) -> Unit) {
    Div {
        H1 { Text("Contact Us") }
        NavButtons(navigateTo)
    }
}

@Composable
fun PrivacyPage(navigateTo: (String) -> Unit) {
    Div {
        H1 { Text("Privacy Policy") }
        NavButtons(navigateTo)
    }
}

@Composable
fun OrderFormPage(navigateTo: (String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Div {
        H1 { Text("Order Form") }
        TextInput(value = name, onInput = { name = it.value }) { Placeholder { Text("Name") } }
        TextInput(value = mobile, onInput = { mobile = it.value }) { Placeholder { Text("Mobile") } }
        TextInput(value = email, onInput = { email = it.value }) { Placeholder { Text("Email") } }
        TextInput(value = address, onInput = { address = it.value }) { Placeholder { Text("Address") } }
        Button(attrs = {
            onClick { navigateTo("order_success") }
        }) {
            Text("Submit")
        }
    }
}

@Composable
fun OrderSuccessPage(navigateTo: (String) -> Unit) {
    Div {
        H1 { Text("Order placed successfully!") }
        Button(attrs = {
            onClick { navigateTo("home") }
        }) {
            Text("OK")
        }
    }
}

@Composable
fun NavButtons(navigateTo: (String) -> Unit) {
    Div {
        Button(attrs = {
            onClick { navigateTo("home") }
        }) { Text("Home") }
        Button(attrs = {
            onClick { navigateTo("contact") }
        }) { Text("Contact Us") }
        Button(attrs = {
            onClick { navigateTo("privacy") }
        }) { Text("Privacy Policy") }
    }
}
