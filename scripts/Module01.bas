Attribute VB_Name = "Module1"

'������� �������� � ������ ��������
Function Rep(ByRef x As String) As String
Rep = Replace(Replace(Replace(Replace(Replace(Replace(Replace(x, "&", "&amp;"), Chr(34), "&quot;"), ">", "&gt;"), "<", "&lt;"), Chr(10), "&#10;"), Chr(0), "&#10;"), "'", "&apos;")
End Function
Sub A_Export_To_Txt()
Attribute A_Export_To_Txt.VB_Description = "������ ������� 12.12.2012"
Attribute A_Export_To_Txt.VB_ProcData.VB_Invoke_Func = " \n14"
'
' export_to_txt ������
'
'Dim name_file As String
Dim name_to As String
Dim yyyy As Integer
Dim mm As Integer
Dim dd As Integer
'���������� ����� �������� �����
'    name_file = Application.ActiveWorkbook.Name
  yyyy = DatePart("yyyy", Now)
  mm = DatePart("m", Now)
  dd = DatePart("d", Now)
  name_to = "c:\erdr" & yyyy & mm & dd & ".xml"
    n = Chr(34)
'���������� ����� ������
Columns("Q:Q").ColumnWidth = 255
'������� � ������� A3!!!!!!!!
    Range("A3").Select
' �������� ����� ��� ������ txt
    Open name_to For Output As #1
    Print #1, "<?xml version=" & n & "1.0" & n & " encoding=" & n & "windows-1251" & n & "?>"
    Print #1, "<ROWS>"
'��������� �� ���� ������� ���� �� ��������� ����� ������
Dim a As Boolean
Dim d As Double
Dim c As Range
a = True
Set c = Range(ActiveCell.Address)
c.Select
d = c.Value
c.Value = d
While (a = True)
    '������ � ����������
    ActiveCell.Offset(0, 1).Select
    name_obt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_rnt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_ovdt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_kdt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_regdt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_hrpdt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_erdr = Right(ActiveCell.Value, 17)
    ActiveCell.Offset(0, 1).Select
    name_pst = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_psf = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_povdt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_vukt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_ukt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_tgt = ActiveCell.Value
    ActiveCell.Offset(0, 1).Select
    name_vrt = ActiveCell.Value
    ActiveCell.Offset(0, 2).Select
    name_fb = ActiveCell.Value
    Print #1, "<ROW OBT='" & Rep(CStr(name_obt)) & "' RNT='" & Rep(CStr(name_rnt)) & "' OVDT='" & Rep(CStr(name_ovdt)) & "' KDT='" & Rep(CStr(name_kdt)) & "' REGDT='" & Rep(CStr(name_regdt)) & "' HRPDT='" & Rep(CStr(name_hrpdt)) & "' ERDR='" & Rep(CStr(name_erdr)) & "' PST='" & Rep(CStr(name_pst)) & "' PSF='" & Rep(CStr(name_psf)) & "' POVDT='" & Rep(CStr(name_povdt)) & "' VUKT='" & Rep(CStr(name_vukt)) & "' UKT='" & Rep(CStr(name_ukt)) & "' TGT='" & Rep(CStr(name_tgt)) & "' VRT='" & Rep(CStr(name_vrt)) & "' FB='" & Rep(CStr(name_fb)) & "' />"
    ActiveCell.Offset(1, -16).Select
If (IsEmpty(ActiveCell.Value) = False) Then
    Set c = Range(ActiveCell.Address)
    c.Select
    d = c.Value
    c.Value = d
Else: a = False
End If
Wend
Print #1, "</ROWS>"
' �������� ����� txt
Close #1
' �������� ����� xls
' Application.ActiveWorkbook.Close
End Sub

