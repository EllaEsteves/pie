package br.com.cursoimpacta.appcadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
// import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cursoimpacta.appcadastro.ui.theme.AppCadastroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCadastroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaPrincipal()
                }
            }
        }
    }
}
@Composable
fun TelaPrincipal() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Column {

            Spacer(modifier = Modifier.padding(90.dp))
            /*BasicTextField(value = ano,
                 modifier = Modifier
                     .border(1.dp, Color.Black)
                     .background(Color(0x00C59941)) //cor de fundo da caixa de texto
                     .fillMaxWidth()
                     .padding(16.dp)
             )*/
            Spacer(modifier = Modifier.padding(16.dp))
            Button( //botão
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color(0x00C59941))
                    .fillMaxWidth()
            ) {
                Text(text = "CADASTRAR")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button( //botão
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color(0x00C59941))
                    .fillMaxWidth()
            ) {
                Text(text = "CONSULTAR CADASTRO")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button( //botão
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color(0x00C59941))
                    .fillMaxWidth()
            ) {
                Text(text = "ALTERAR CADASTRO")
            }

        }
    }
}
@Preview
@Composable
fun PreviewTelaPrincipal() {
    TelaPrincipal()

}