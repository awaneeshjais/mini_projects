Attribute VB_Name = "Module11"
Sub A_Insert_TEMA_One_page()

Range("A1").Select
ActiveCell.EntireRow.Select
Selection.Insert Shift:=xlDown
ActiveCell.Offset(1, 1).Select
ActiveCell.Offset(-1, 0).Select
ActiveCell.FormulaR1C1 = InputBox("Введите тему для разбивки:", "Внимание", "...")
Selection.Font.Bold = True
Selection.HorizontalAlignment = xlCenter
Selection.Resize(Selection.Rows.Count, Selection.Columns.Count + 5).Select
Selection.Merge
Selection.Font.Size = 20
Range("A1").Select
End Sub

