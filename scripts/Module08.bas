Attribute VB_Name = "Module8"
'функция замены слов на номер
Function ToNull(ByRef x As String) As String
If (x = "") Then
    ToNull = "null"
Else
     ToNull = x
End If
End Function
Sub A_Empty_To_Null()
'Макрос2 Макрос
' False
'перебежка по всем строкам вниз до последней внизу пустой
While (Range(H50000))
text = ActiveCell.Value
ActiveCell.FormulaR1C1 = ToNull(text)
ActiveCell.Offset(1, 0).Select
End If
Wend
End Sub





