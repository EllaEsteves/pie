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

@Composable
fun NomeInput() {
    var nome by remember {
        mutableStateOf("")
    }
    var msgNome by remember {
        mutableStateOf("")
    }
    Column {
        Spacer(modifier = Modifier.padding(50.dp))
        Text(text = "Nome Completo: ") // Título nome
        TextField(
            value = nome,
            onValueChange = {
                nome = it
                if (!isValidNome(nome)) {
                    msgNome = "Digite um nome e sobrenome válido"
                } else {
                    msgNome = ""
                }
            },
            label = { Text(text = "Digite seu nome completo") },
            modifier = Modifier
                .border(1.dp, Color.Black)
                .background(Color(0x00C59941)) //cor de fundo da caixa de texto
                .fillMaxWidth()
                .padding(10.dp)
        )
        // Exibir mensagem de erro
        Text(text = msgNome)
    }
}

// Função para validar nome
fun isValidNome(nome: String): Boolean {
    val nomes = nome.trim().split(" ")
    if (nomes.size < 2) return false // Verifica se há pelo menos dois nomes

    for (nome in nomes) {
        if (nome.length < 3) return false // Verifica se cada nome tem pelo menos 3 letras
    }

    return true
}

@Preview
@Composable
fun PreviewNomeInput() {
    NomeInput()
}
