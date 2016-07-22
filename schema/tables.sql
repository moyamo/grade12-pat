-- TODO Add gender
-- TODO Move cellphone number into billing information ?
create table Patient (
	id integer primary key,
	firstNames varchar(30),
	surname varchar(30),
	idNumber varchar(20),
	cellphoneNumber varChar(20),
	birthday date
);

create table PatientMedicalHistory (
	id integer primary key,
	patientId integer not null,
	notes long varchar not null,
	foreign key (patientId) references Patient(id)
);

create table PatientFileAttachments (
	id integer primary key,
	medicalHistoryId integer not null,
	path VARCHAR(256) not null,
	foreign key (medicalHistoryId) references PatientMedicalHistory(id)
);

create table PatientReadings (
	id integer primary key,
	medicalHistoryId integer not null,
	reading double not null,
	readingType VARCHAR(20) not null,
	time date not null,
	foreign key (medicalHistoryId) references PatientMedicalHistory(id)
);



create table BillingItems (
	id integer primary key,
	description VARCHAR(30) not null,
	price decimal not null
);

create table Allergies (
	id integer primary key,
	allergyType VARCHAR(30) not null,
	patientId integer not null,
	foreign key (patientId) references Patient(id)
);


create table Appointments (
	id integer,
	doctor VARCHAR(30) not null,
	patientId integer not null,
	time date not null,
	primary key (id),
	foreign key (patientId) references Patient(id)
);
create table BillingHistory (
	id integer primary key,
	patientId integer not null,
	emailAddress VARCHAR(255),
	description VARCHAR(30) not null,
	price decimal not null,
	time date,
	consultationId integer,
	foreign key (patientId) references Patient(id),
	foreign key (consultationId) references Appointments(id)
);

create table MedicalAid (
	id integer primary key,
	name VARCHAR(30),
	address varchar(255),
	phonenumber varchar(15),
	emailAddress varchar(255)
);

-- Note that dependents  will have the same medical aid plan and that is the 
-- correct way to identify dependents
create table MedicalAidPlan (
	id integer primary key,
	medicalAidId integer,
	medicalAidNumber VARCHAR(30),
	primaryMemberId integer,
	foreign key (medicalAidId) references MedicalAid(id),
	foreign key (primaryMemberId) references Patient(id)
);
create table PatientBillingDetails (
	id integer primary key,
	patientId integer not null,
	emailAddress VARCHAR(255),
	homeAddress VARCHAR(255),
	medicalAidPlanId integer,
	paymentMethod VARCHAR(10),
	foreign key (patientId) references Patient(id),
	foreign key (medicalAidPlanId) references MedicalAid(id)
);
