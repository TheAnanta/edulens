package dev.theananta.edulens.ui

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.theananta.edulens.model.University


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun <T> DropDownTextField(
    modifier: Modifier = Modifier,
    options: List<T>,
    optionsText: (T) -> String = { it.toString() },
    textfield: @Composable (modifier: Modifier, trailingIcon: @Composable () -> Unit) -> Unit = { _, t -> },
    menuItemColors: MenuItemColors = MenuDefaults.itemColors(),
    onChooseOption: (T) -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }) {
        textfield(modifier.menuAnchor(), {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
        })
        DropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {
            options.forEach { option ->
                DropdownMenuItem(text = {
                    Text(optionsText(option))
                }, onClick = {
                    onChooseOption(option)
                    expanded = false
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> OutlinedDropdownTextField(
    modifier: Modifier = Modifier,
    options: List<T>,
    selected: T,
    label: String = "",
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    menuItemColors: MenuItemColors = MenuDefaults.itemColors(),
    onChooseOption: (T) -> Unit,
) {
    DropDownTextField(
        modifier = modifier,
        options = options,
        textfield = { textfieldModifier, trailingIcon ->
            OutlinedTextField(
                value = selected?.toString() ?: "",
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(label)
                },
                modifier = textfieldModifier,
                trailingIcon = trailingIcon,
                colors = colors
            )
        },
        onChooseOption = onChooseOption,
        menuItemColors = menuItemColors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedDropdownTextField(
    modifier: Modifier = Modifier,
    options: List<University>,
    selected: String?,
    label: String = "",
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    menuItemColors: MenuItemColors = MenuDefaults.itemColors(),
    onChooseOption: (University?) -> Unit,
) {
    DropDownTextField(
        modifier = modifier,
        options = options,
        optionsText = {
            it.name
        },
        textfield = { textfieldModifier, trailingIcon ->
            OutlinedTextField(
                value = selected?.toString() ?: "",
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(label)
                },
                modifier = textfieldModifier,
                trailingIcon = trailingIcon,
                colors = colors
            )
        },
        onChooseOption = onChooseOption,
        menuItemColors = menuItemColors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> FilledDropDownTextField(
    modifier: Modifier = Modifier,
    options: List<T>,
    selected: T,
    label: String = "",
    onChooseOption: (T) -> Unit,
) {
    DropDownTextField(options = options, textfield = { textfieldModifier, trailingIcon ->
        TextField(
            value = selected?.toString() ?: "",
            onValueChange = {},
            readOnly = true,
            label = {
                Text(label)
            },
            modifier = textfieldModifier,
            trailingIcon = trailingIcon
        )
    }, onChooseOption = onChooseOption)
}