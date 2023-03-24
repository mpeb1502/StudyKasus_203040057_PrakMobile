package id.ac.unpas.ShowroomMotor.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.ShowroomMotor.model.ShowroomMotor
import id.ac.unpas.ShowroomMotor.ui.theme.Purple700
import id.ac.unpas.ShowroomMotor.ui.theme.Teal200


@Composable
fun FormShowroomMotor(onSimpan: (ShowroomMotor) -> Unit) {
    val context = LocalContext.current
    val id = remember { mutableStateOf(TextFieldValue("")) }
    val namaPembeli = remember { mutableStateOf(TextFieldValue("")) }
    val harga = remember { mutableStateOf(TextFieldValue("")) }
    val merkMotor = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Id") },
            value = id.value,
            onValueChange = {
                id.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "01") }
        )
        OutlinedTextField(
            label = { Text(text = "NamaPembeli") },
            value = namaPembeli.value,
            onValueChange = {
                namaPembeli.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "NamaPembeli") }
        )
        OutlinedTextField(
            label = { Text(text = "Harga") },
            value = harga.value,
            onValueChange = {
                harga.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "001") }
        )
        OutlinedTextField(
            label = { Text(text = "Merek Motor") },
            value = merkMotor.value,
            onValueChange = {
                merkMotor.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Merek Motor") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row(modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val idValue = id.value.text
                val namaPembeliValue = namaPembeli.value.text
                val hargaValue = harga.value.text
                val merkMotorValue = merkMotor.value.text

                // validasi inputan id dan namaPembeli
                if (idValue.isBlank() || namaPembeliValue.isBlank()) {
                    Toast.makeText(context, "id dan namaPembeli harus diisi", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                // validasi inputan harga dan merkMotor
                if (hargaValue.isBlank() && merkMotorValue.isBlank()) {
                    Toast.makeText(context, "harga atau merkMotor harus diisi salah satu", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val item = ShowroomMotor(idValue, namaPembeliValue, hargaValue, merkMotorValue)
                onSimpan(item)
                id.value = TextFieldValue("")
                namaPembeli.value = TextFieldValue("")
                harga.value = TextFieldValue("")
                merkMotor.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                id.value = TextFieldValue("")
                namaPembeli.value = TextFieldValue("")
                harga.value = TextFieldValue("")
                merkMotor.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }

    }
}