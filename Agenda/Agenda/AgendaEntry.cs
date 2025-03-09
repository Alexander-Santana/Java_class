using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Agenda
{
    internal class AgendaEntry
    {
        public string Name { get; set; }        // Name of the agenda item
        public string Description { get; set; } // Description of the task/appointment
        public DateTime DueDate { get; set; }   // Date of the entry
        public string Type { get; set; }        // "Task" or "Appointment"
    }
}

