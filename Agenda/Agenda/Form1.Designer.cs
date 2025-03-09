namespace Agenda
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            textBoxDate = new TextBox();
            labelDayOfWeek = new Label();
            groupBoxEntryType = new GroupBox();
            radioBoth = new RadioButton();
            radioAppointment = new RadioButton();
            radioTask = new RadioButton();
            listBoxAgenda = new ListBox();
            btnLoadAgenda = new Button();
            btnClearAgenda = new Button();
            btnExit = new Button();
            groupBoxEntryType.SuspendLayout();
            SuspendLayout();
            // 
            // textBoxDate
            // 
            textBoxDate.Location = new Point(329, 40);
            textBoxDate.Name = "textBoxDate";
            textBoxDate.Size = new Size(154, 27);
            textBoxDate.TabIndex = 0;
            // 
            // labelDayOfWeek
            // 
            labelDayOfWeek.BorderStyle = BorderStyle.FixedSingle;
            labelDayOfWeek.Location = new Point(549, 40);
            labelDayOfWeek.Name = "labelDayOfWeek";
            labelDayOfWeek.Size = new Size(203, 34);
            labelDayOfWeek.TabIndex = 1;
            labelDayOfWeek.Text = "Day of Week (ie. Monday)";
            // 
            // groupBoxEntryType
            // 
            groupBoxEntryType.Controls.Add(radioBoth);
            groupBoxEntryType.Controls.Add(radioAppointment);
            groupBoxEntryType.Controls.Add(radioTask);
            groupBoxEntryType.Location = new Point(484, 143);
            groupBoxEntryType.Name = "groupBoxEntryType";
            groupBoxEntryType.Size = new Size(268, 141);
            groupBoxEntryType.TabIndex = 2;
            groupBoxEntryType.TabStop = false;
            groupBoxEntryType.Text = "Entry Type";
            // 
            // radioBoth
            // 
            radioBoth.AutoSize = true;
            radioBoth.Location = new Point(16, 97);
            radioBoth.Name = "radioBoth";
            radioBoth.Size = new Size(61, 24);
            radioBoth.TabIndex = 2;
            radioBoth.TabStop = true;
            radioBoth.Text = "Both";
            radioBoth.UseVisualStyleBackColor = true;
            // 
            // radioAppointment
            // 
            radioAppointment.AutoSize = true;
            radioAppointment.Location = new Point(16, 67);
            radioAppointment.Name = "radioAppointment";
            radioAppointment.Size = new Size(118, 24);
            radioAppointment.TabIndex = 1;
            radioAppointment.TabStop = true;
            radioAppointment.Text = "Appointment";
            radioAppointment.UseVisualStyleBackColor = true;
            // 
            // radioTask
            // 
            radioTask.AutoSize = true;
            radioTask.Location = new Point(16, 37);
            radioTask.Name = "radioTask";
            radioTask.Size = new Size(57, 24);
            radioTask.TabIndex = 0;
            radioTask.TabStop = true;
            radioTask.Text = "Task";
            radioTask.UseVisualStyleBackColor = true;
            // 
            // listBoxAgenda
            // 
            listBoxAgenda.FormattingEnabled = true;
            listBoxAgenda.Location = new Point(72, 143);
            listBoxAgenda.Name = "listBoxAgenda";
            listBoxAgenda.Size = new Size(381, 244);
            listBoxAgenda.TabIndex = 3;
            // 
            // btnLoadAgenda
            // 
            btnLoadAgenda.Location = new Point(75, 406);
            btnLoadAgenda.Name = "btnLoadAgenda";
            btnLoadAgenda.Size = new Size(111, 29);
            btnLoadAgenda.TabIndex = 4;
            btnLoadAgenda.Text = "Load Agenda";
            btnLoadAgenda.UseVisualStyleBackColor = true;
            btnLoadAgenda.Click += btnLoadAgenda_Click;
            // 
            // btnClearAgenda
            // 
            btnClearAgenda.Location = new Point(359, 409);
            btnClearAgenda.Name = "btnClearAgenda";
            btnClearAgenda.Size = new Size(111, 29);
            btnClearAgenda.TabIndex = 5;
            btnClearAgenda.Text = "Clear Agenda";
            btnClearAgenda.UseVisualStyleBackColor = true;
            btnClearAgenda.Click += btnClearAgenda_Click;
            // 
            // btnExit
            // 
            btnExit.Location = new Point(605, 406);
            btnExit.Name = "btnExit";
            btnExit.Size = new Size(104, 29);
            btnExit.TabIndex = 6;
            btnExit.Text = "Exit";
            btnExit.UseVisualStyleBackColor = true;
            btnExit.Click += btnExit_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnExit);
            Controls.Add(btnClearAgenda);
            Controls.Add(btnLoadAgenda);
            Controls.Add(listBoxAgenda);
            Controls.Add(groupBoxEntryType);
            Controls.Add(labelDayOfWeek);
            Controls.Add(textBoxDate);
            Name = "Form1";
            Text = "Form1";
            groupBoxEntryType.ResumeLayout(false);
            groupBoxEntryType.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBoxDate;
        private Label labelDayOfWeek;
        private GroupBox groupBoxEntryType;
        private RadioButton radioBoth;
        private RadioButton radioAppointment;
        private RadioButton radioTask;
        private ListBox listBoxAgenda;
        private Button btnLoadAgenda;
        private Button btnClearAgenda;
        private Button btnExit;
    }
}
