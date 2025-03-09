// Chapters 8 & 9
// Project #1 "Agenda"
// Alexander Santana
// 3/3/2025

namespace Agenda
{
    public partial class Form1 : Form
    {
        private List<AgendaEntry> agendaList = new List<AgendaEntry>();

        public Form1()
        {
            InitializeComponent();
        }

        private void btnLoadAgenda_Click(object sender, EventArgs e)
        {
            if (!DateTime.TryParse(textBoxDate.Text, out DateTime enteredDate))
            {
                MessageBox.Show("Eenter a valid date layout (m/d/yyyy).");
                return;
            }

            labelDayOfWeek.Text = enteredDate.ToString("dddd");
            LoadAgendaFromFile(enteredDate);
        }

        private void LoadAgendaFromFile(DateTime enteredDate)
        {
            agendaList.Clear();
            listBoxAgenda.Items.Clear();

            string filePath = "EntryList.txt";

            if (!File.Exists(filePath))
            {
                MessageBox.Show("EntryList.txt file missing");
                return;
            }

            string[] lines = File.ReadAllLines(filePath);

            foreach (string line in lines)
            {
                string[] tokens = line.Split(',');
                if (tokens.Length < 4) continue;

                if (!DateTime.TryParse(tokens[3], out DateTime dueDate))
                    continue;

                AgendaEntry entry = new AgendaEntry
                {
                    Name = tokens[1].Trim(),
                    Description = tokens[2].Trim(),
                    DueDate = dueDate,
                    Type = (tokens[4].Trim() == "T") ? "Task" : "Appointment"
                };
                agendaList.Add(entry);
            }

            var filteredEntries = agendaList.Where(entry =>
                entry.DueDate.Date == enteredDate.Date &&
                (radioTask.Checked && entry.Type == "Task" ||
                 radioAppointment.Checked && entry.Type == "Appointment" ||
                 radioBoth.Checked)).ToList();

            foreach (var entry in filteredEntries)
            {
                listBoxAgenda.Items.Add($"{entry.DueDate:MM/dd/yyyy} - {entry.Name} ({entry.Type}) - {entry.Description}");
            }

            if (listBoxAgenda.Items.Count == 0)
            {
                listBoxAgenda.Items.Add("No agenda stuff found.");
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnClearAgenda_Click(object sender, EventArgs e)
        {
            textBoxDate.Clear();
            labelDayOfWeek.Text = "";
            listBoxAgenda.Items.Clear();
        }
    }
}
