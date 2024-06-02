package br.com.cursoimpacta.appcadastro


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.cursoimpacta.appcadastro.ui.theme.AppCadastroTheme
import androidx.compose.ui.tooling.preview.Preview as Preview1

class MainActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCadastroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Cadastro { navController.navigate("Cadastro") }
                }
            }
        }
    }

}


@Composable
fun Cadastro(onSignInClick: () -> Unit) {
    var nome by remember {
        mutableStateOf("")
    }
    var cep by remember { mutableStateOf<CepResponse?>(null) }
    var msgCep by remember { mutableStateOf("") }

    var msgNome by remember {
        mutableStateOf("")
    }
    var click by remember {
        mutableStateOf("")
    }

    var endereco by remember {
        mutableStateOf("")
    }
    val partesNome = nome.split(" ")
    val coroutineScope = rememberCoroutineScope()
    val api = remember {
        viaCep.create()
    }

    Surface( // Componente gráfico usado para desenhar conteúdo na tela
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
    ) {
        // Spacer(modifier = Modifier.padding(50.dp)) espaçamento nome
        Column {
            NomeInput()

        }
        // Spacer(modifier = Modifier.padding(130.dp)) espaçamento email
        Column {
            EmailInput()
        }

        // Spacer(modifier = Modifier.padding(170.dp)) espaçamento cep
        Column {

            CepInputComponent(
                onCepSubmitted = { data, msg ->
                    cep = data
                    if (data?.erro ?: "" == "true") {
                        msgCep = "CEP inválido"
                    }
                },
                LimpaCEP = {
                    cep = null
                    msgCep = ""
                }
            )

            Text(msgCep)
            CepDisplayComponent(cep)

        }

    }
}


@Preview1
@Composable
fun PreviewCadastro() {
    var cep by remember { mutableStateOf<CepResponse?>(null)}
    var mensagem by remember {
        mutableStateOf("")
    }
    val navController = rememberNavController()
    // CepResponse com ? permite ser nulo. Se não tiver o ?, ele fica com erro no "null"
    AppCadastroTheme{
        NomeInput()
        EmailInput()
        Column {
            Cadastro { navController.navigate("Cadastro") }
            CepInputComponent(onCepSubmitted = { data, msg ->
                cep = data
                if (data?.erro ?: "" == "true") {
                    mensagem = "CEP Inválido"
                }
            }
            ) {
                cep = null
                mensagem = ""
            }
            CepDisplayComponent(cep)

        }
    }
}

