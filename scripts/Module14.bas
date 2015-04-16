Attribute VB_Name = "Module14"
Sub OSK_CPABHEHIE()
'перебежка по всем строкам вниз до последней внизу пустой
Dim text As String
FindString = ""
Dim a As Boolean
Dim d As String
Dim c As Range
Dim f As Range
a = True
Set c = Range(ActiveCell.Address)
c.Select
d = c.Value
c.Value = d
While (a = True)
    FindString = ActiveCell.Value
    With Worksheets("2").Range("b1:b5500")
    Set c = .Find(FindString, LookIn:=xlValues)
    If Not c Is Nothing Then
        Sheets("2").Select
        c.Select
        ActiveCell.EntireRow.Select
        Selection.Copy
        Sheets("1").Select
        ActiveCell.Select
        ActiveSheet.Paste
    End If
    End With
Sheets("1").Select
ActiveCell.Select

ActiveCell.Offset(1, 0).Select

If (IsEmpty(ActiveCell.Value) = False) Then
    Set c = Range(ActiveCell.Address)
    c.Select
    d = c.Value
    c.Value = d
Else: a = False
End If
Wend
End Sub
