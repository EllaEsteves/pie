package br.com.cursoimpacta.appcadastro

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


var msgEmail: String = ""

@Composable
fun EmailInput() {
    var email by remember {
        mutableStateOf("")
    }
    Column {
        Spacer(modifier = Modifier.padding(113.dp))
        Text(text = "E-mail:") // Título email
        TextField(
            value = email,
            onValueChange = {
                email = it
                if (it.length <= 1) {
                    msgEmail = "Digite um e-mail válido"
                } else {
                    validateEmail(email)
                }
            },
            label = { Text(text = "Digite seu e-mail") },
            modifier = Modifier
                .border(1.dp, Color.Black)
                .background(Color(0x00C59941)) //cor de fundo da caixa de texto
                .fillMaxWidth()
                .padding(10.dp)
        )
        // Exibir mensagem de erro
        Text(text = msgEmail)
    }
}

// Função para validar e-mail
fun validateEmail(email: String) {

    val regex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    val isValid = regex.matches(email)
    if (!isValid) {
        msgEmail = "Email inválido"
    } else
        msgEmail = ""
}

@Preview
@Composable
fun PreviewEmailInput() {
    EmailInput()
}
