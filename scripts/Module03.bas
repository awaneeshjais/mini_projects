Attribute VB_Name = "Module3"
Sub A_Delilo_HA_PB_One_page()
Attribute A_Delilo_HA_PB_One_page.VB_Description = "Макрос записан 12.02.2013"
Attribute A_Delilo_HA_PB_One_page.VB_ProcData.VB_Invoke_Func = " \n14"
' init loop
Dim a As Boolean
Dim d As String
' init str
Dim up_cell As String
Dim dw_cell As String
Dim tema As String



a = True
tema = InputBox("Введите тему для разбивки:", "Внимание", "...")
While (a = True)
If (IsEmpty(ActiveCell.Value) = False) Then
    ActiveCell.Select
    up_cell = ActiveCell.Value
    ActiveCell.Offset(1, 0).Select
    dw_cell = ActiveCell.Value
    If (up_cell <> dw_cell) Then
          ActiveCell.EntireRow.Select
          Selection.Insert Shift:=xlDown
          ActiveCell.Select
          ActiveCell.FormulaR1C1 = tema
          Selection.Font.Bold = True
          Selection.HorizontalAlignment = xlCenter
          Selection.Resize(Selection.Rows.Count, Selection.Columns.Count + 3).Select
          Selection.Merge
          ActiveCell.Offset(1, 0).Select
          
    Else:
    
    End If
    
Else: a = False
End If
up_cell = ""
dw_cell = ""
'ActiveCell.Offset(1, 0).Select
Wend
ActiveCell.Offset(-1, 0).Select
ActiveCell.EntireRow.Select
Selection.Delete Shift:=xlDown
'ActiveCell.Offset(-1, 0).Select
Range("A1").Select
End Sub
