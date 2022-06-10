CREATE TABLE Patient (
    PatientID INT IDENTITY(11,1) PRIMARY KEY,
    PatientName VARCHAR(30) NOT NULL,
    PatientDOB DATE CHECK (PatientDOB BETWEEN '10-FEB-2020' AND GETDATE()) NOT NULL,
	IDProofType VARCHAR(20) NOT NULL,
	IDProofNo CHAR(12),
	GENDER VARCHAR(9),
    check(GENDER in ('Male', 'Female'))
);

INSERT INTO PatientAdministration.Patient(PatientName,PatientDOB, IDProofType, IDProofNo, GENDER)
VALUES ('SITA', '10-JUNE-2021','ADHARCARD', '34567886', 'MALE');

SELECT * FROM PatientAdministration.Patient;

DROP TABLE PatientAdministration.Patient;
DROP TABLE PatientAdministrationone.Nextofkin;


CREATE Schema PatientAdministrationone

CREATE TABLE PatientAdministration.Patient (
    PatientID INT IDENTITY(11,1) PRIMARY KEY,
    PatientName VARCHAR(30) NOT NULL,
	PatientDOB DATE CHECK (PatientDOB BETWEEN '10-FEB-2020' AND GETDATE()) NOT NULL,
	IDProofType VARCHAR(20) NOT NULL,
	IDProofNo CHAR(12),
	GENDER VARCHAR(9)
    
);

SELECT * FROM PatientAdministration.Patient;
SELECT * FROM PatientAdministrationone.Nextofkin;


INSERT INTO PatientAdministration.Patient(PatientName, IDProofType, IDProofNo, GENDER)
VALUES ('SITA', 'ADHARCARD', '34567886', 'MALE');

CREATE TABLE PatientAdministrationone.Nextofkin (
    kinID INT IDENTITY(11,1) PRIMARY KEY,
    relativename VARCHAR(30) NOT NULL,
	relation VARCHAR(20) NOT NULL,
	patientID INT REFERENCES PatientAdministration.Patient(PatientID) NOT NULL
    
);