# Convert all lab reports to a single DOCX
# Requires pandoc (https://pandoc.org/installing.html)
# Install: winget install JohnMacFarlane.Pandoc  OR  choco install pandoc

# Refresh PATH so newly installed pandoc is found
$env:Path = [Environment]::GetEnvironmentVariable("Path", "Machine") + ";" + [Environment]::GetEnvironmentVariable("Path", "User")

$base = "C:\Users\Rons\OneDrive\Desktop\Coding\java\temp\ronish-java-labs"
$output = "C:\Users\Rons\OneDrive\Desktop\Coding\java\temp\Ronish_Java_Lab_Report.docx"

$labs = @(
    "01-mouse-sum-diff",
    "02-add-two-numbers",
    "03-calculator-radio",
    "04-sum-diff-adapter",
    "05-login-gridlayout",
    "06-login-gridbaglayout",
    "07-calculator-borderlayout",
    "08a-button-color",
    "08b-form-background-color",
    "09-layout-manager-demo",
    "10-shape-drawer",
    "11-color-changer-radio",
    "12-toolbar-icons",
    "13-jdbc-insert-students",
    "14-jdbc-update-salary",
    "15-jdbc-create-table",
    "16-jdbc-resultset-nav",
    "17-jdbc-updatable-resultset",
    "18-servlet-lifecycle",
    "19-servlet-session",
    "20-servlet-cookies",
    "21-jsp-cookies",
    "22-jsp-form-display",
    "23-jsp-simple-interest",
    "24-rmi-adder"
)

Write-Host "Building combined markdown..."
$combined = "# Ronish's Java Lab Report`n`n"
foreach ($lab in $labs) {
    $reportPath = Join-Path $base "$lab\report.md"
    if (Test-Path $reportPath) {
        $content = Get-Content $reportPath -Raw
        $combined += $content + "`n---`n`n"
    }
}

$combinedMd = Join-Path $base "_combined_report.md"
Set-Content -Path $combinedMd -Value $combined
Write-Host "Combined markdown saved: $combinedMd"

$pandoc = Get-Command pandoc -ErrorAction SilentlyContinue
if ($pandoc) {
    Write-Host "Generating DOCX with pandoc..."
    & pandoc $combinedMd -o $output --from markdown --to docx
    Write-Host "Done: $output"
} else {
    Write-Host @"
pandoc not found. Install it first:
  winget install pandoc
or download from https://pandoc.org/installing.html

Then run this script again. The combined markdown is already at:
  $combinedMd

You can also convert it manually:
  pandoc "$combinedMd" -o "$output"
"@
}
