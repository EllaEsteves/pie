package br.com.cursoimpacta.appcadastro

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import retrofit2.Response



@Composable
fun CepInputComponent(onCepSubmitted: (CepResponse?, String?) -> Unit, LimpaCEP: () -> Unit) {

    //declaração de variaveis
    var cep by remember {
        mutableStateOf("")
    }
    var msgCEP by remember {
        mutableStateOf("")
    }
    val coroutineScope = rememberCoroutineScope()

    var api = remember {
        viaCep.create()
    }

    Column {
        Spacer(modifier = Modifier.padding(105.dp))
        Text(text = "ENDEREÇO")
        Row(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(10.dp)
        ) {
            TextField(value = cep, onValueChange = {
                cep = it
                LimpaCEP()
            },
                label = { Text(text = "Digite o CEP") }
            )
            Spacer(modifier = Modifier.padding(4.dp)) // espaço entre texto e botao
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (cep.length != 8) {
                            msgCEP = "Digite um cep válido"
                        } else {
                            coroutineScope.launch {
                                var response: Response<CepResponse>

                                response = api.fetchCep(cep)
                                if (response.isSuccessful && response.body() != null) {
                                    if (response.body()!!.erro) {
                                        msgCEP = "CEP Inválido"
                                    } else {
                                        onCepSubmitted(response.body(), msgCEP)
                                    }
                                }
                            }
                        }
                    }
                }
            ) {

                Text("IR")
            }
        }
    }
    Row {
        Text(msgCEP)
    }
}


@Composable
fun CepDisplayComponent(data: CepResponse?) {
    var rua by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(16.dp)) {
        if (data != null) {
            /*   TextField(value = rua, onValueChange = {
                   if (data != null) {
                       rua = data.logradouro
                   } else {
                       rua = ""
                   }

               }, //Text("Rua: ${data?.logradouro}"),
                 label = { Text(text = "Rua") }) */
            Text("CEP: ${data.cep}")
            Text("Rua: ${data.logradouro}")
            Text("Complemento: ${data.complemento}")
            Text("Bairro: ${data.bairro}")
            Text("Localidade: ${data.localidade}")
            Text("UF: ${data.uf}")
            Text("DDD: ${data.ddd}")

        } else {
            Text("")
        }
    }
}
//}





