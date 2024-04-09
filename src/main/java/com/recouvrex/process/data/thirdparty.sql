-- generated code for creating the thirdparty
CREATE TABLE public.thirdparty (
  id INT8 NOT NULL DEFAULT unique_rowid(),
  birth_date DATE NULL,
  business_email VARCHAR(255) NULL,
  business_phone VARCHAR(255) NULL,
  business_sector VARCHAR(255) NULL,
  commercial_register VARCHAR(255) NULL,
  company_name VARCHAR(255) NULL,
  country_of_residence VARCHAR(255) NULL,
  fax_number VARCHAR(255) NULL,
  first_name VARCHAR(255) NULL,
  land_line_phone VARCHAR(255) NULL,
  last_name VARCHAR(255) NULL,
  legal_form VARCHAR(255) NULL,
  marital_status VARCHAR(255) NULL,
  nationality VARCHAR(255) NULL,
  occupation VARCHAR(255) NULL,
  personal_email VARCHAR(255) NULL,
  private_phone VARCHAR(255) NULL,
  supporting_document_expiration_date DATE NULL,
  supporting_document_number VARCHAR(255) NULL,
  supporting_document_type VARCHAR(255) NULL,
  tiers_type VARCHAR(255) NULL,
  title VARCHAR(255) NULL,
  CONSTRAINT thirdparty_pkey PRIMARY KEY (id ASC),
  CONSTRAINT check_supporting_document_type CHECK (supporting_document_type IN ('CIN':::STRING, 'PASSPORT':::STRING, 'RESIDENCE_CARD':::STRING)),
  CONSTRAINT check_tiers_type CHECK (tiers_type IN ('CUSTOMER_PP':::STRING, 'CUSTOMER_PM':::STRING, 'INSURANCE_COMPANY':::STRING, 'GUARANTOR':::STRING, 'USER':::STRING))
)

-- example the code to insert a thirdparty
INSERT INTO public.thirdparty (
    id,
    birth_date, 
    business_email, 
    business_phone, 
    business_sector, 
    commercial_register, 
    company_name, 
    country_of_residence, 
    fax_number, 
    first_name, 
    land_line_phone, 
    last_name, 
    legal_form, 
    marital_status, 
    nationality, 
    occupation, 
    personal_email, 
    private_phone, 
    supporting_document_expiration_date, 
    supporting_document_number, 
    supporting_document_type, 
    tiers_type, 
    title
) VALUES (
    1,
    '1980-01-01', -- birth_date example
    'john.doe@example.com', -- business_email example
    '123-456-7890', -- business_phone example
    'Technology', -- business_sector example
    'ABC123456789', -- commercial_register example
    'Doe Enterprises', -- company_name example
    'France', -- country_of_residence example
    '123-456-7891', -- fax_number example
    'John', -- first_name example
    '123-456-7892', -- land_line_phone example
    'Doe', -- last_name example
    'SARL', -- legal_form example
    'Single', -- marital_status example
    'French', -- nationality example
    'Software Developer', -- occupation example
    'john.private@example.com', -- personal_email example
    '098-765-4321', -- private_phone example
    '2025-01-01', -- supporting_document_expiration_date example
    'XD1234567', -- supporting_document_number example
    'PASSPORT', -- supporting_document_type example (must comply with the check constraint)
    'CUSTOMER_PP', -- tiers_type example (must comply with the check constraint)
    'Mr.' -- title example
);


INSERT INTO public.thirdparty (
  id,
  birth_date, 
  business_email, 
  business_phone, 
  business_sector, 
  commercial_register, 
  company_name, 
  country_of_residence, 
  fax_number, 
  first_name, 
  land_line_phone, 
  last_name, 
  legal_form, 
  marital_status, 
  nationality, 
  occupation, 
  personal_email, 
  private_phone, 
  supporting_document_expiration_date, 
  supporting_document_number, 
  supporting_document_type, 
  tiers_type, 
  title
) VALUES 
(2, '1980-02-02', 'email2@example.com', '234-567-8901', 'Retail', 'REG234567', 'Company Two', 'Germany', '234-567-8902', 'Anna', '234-567-8903', 'Smith', 'GmbH', 'Married', 'German', 'Manager', 'anna.smith@example.com', '987-654-3210', '2026-02-02', 'AB2345678', 'CIN', 'CUSTOMER_PM', 'Mrs.'),
(3, '1980-03-03', 'email3@example.com', '345-678-9012', 'Finance', 'REG345678', 'Company Three', 'Italy', '345-678-9013', 'Marco', '345-678-9014', 'Rossi', 'S.p.A.', 'Single', 'Italian', 'Accountant', 'marco.rossi@example.com', '876-543-2109', '2027-03-03', 'BC3456789', 'PASSPORT', 'CUSTOMER_PP', 'Mr.'),
(4, '1980-04-04', 'email4@example.com', '456-789-0123', 'IT Services', 'REG456789', 'Company Four', 'Canada', '456-789-0124', 'Susan', '456-789-0125', 'Johnson', 'Inc.', 'Divorced', 'Canadian', 'Engineer', 'susan.johnson@example.com', '765-432-1098', '2028-04-04', 'CD4567890', 'RESIDENCE_CARD', 'CUSTOMER_PP', 'Ms.'),
(5, '1980-05-05', 'email5@example.com', '567-890-1234', 'Healthcare', 'REG567890', 'Company Five', 'Japan', '567-890-1235', 'Yuto', '567-890-1236', 'Takahashi', 'KK', 'Married', 'Japanese', 'Doctor', 'yuto.takahashi@example.com', '654-321-0987', '2029-05-05', 'DE5678901', 'CIN', 'CUSTOMER_PP', 'Dr.'),
(6, '1980-06-06', 'email6@example.com', '678-901-2345', 'Education', 'REG678901', 'Company Six', 'Australia', '678-901-2346', 'Olivia', '678-901-2347', 'Brown', 'Pty Ltd', 'Single', 'Australian', 'Teacher', 'olivia.brown@example.com', '543-210-9876', '2030-06-06', 'EF6789012', 'PASSPORT', 'CUSTOMER_PM', 'Ms.'),
(7, '1980-07-07', 'email7@example.com', '789-012-3456', 'Manufacturing', 'REG789012', 'Company Seven', 'Brazil', '789-012-3457', 'Lucas', '789-012-3458', 'Silva', 'Ltda', 'Married', 'Brazilian', 'Engineer', 'lucas.silva@example.com', '432-109-8765', '2031-07-07', 'FG7890123', 'RESIDENCE_CARD', 'CUSTOMER_PP', 'Mr.'),
(8, '1980-08-08', 'email8@example.com', '890-123-4567', 'Automotive', 'REG890123', 'Company Eight', 'Russia', '890-123-4568', 'Ivan', '890-123-4570', 'Petrov', 'OOO', 'Widowed', 'Russian', 'Mechanical Engineer', 'ivan.petrov@example.com', '432-098-7654', '2032-08-08', 'GH8901234', 'CIN', 'CUSTOMER_PM', 'Mr.'),
(9, '1980-09-09', 'email9@example.com', '901-234-5678', 'Agriculture', 'REG901234', 'Company Nine', 'India', '901-234-5679', 'Priya', '901-234-5680', 'Kumar', 'Pvt Ltd', 'Married', 'Indian', 'Farmer', 'priya.kumar@example.com', '321-987-6543', '2033-09-09', 'HI9012345', 'PASSPORT', 'CUSTOMER_PP', 'Mrs.'),
(10, '1980-10-10', 'email10@example.com', '012-345-6789', 'Real Estate', 'REG012345', 'Company Ten', 'Spain', '012-345-6790', 'Carlos', '012-345-6791', 'Garcia', 'S.L.', 'Single', 'Spanish', 'Real Estate Agent', 'carlos.garcia@example.com', '210-876-5432', '2034-10-10', 'IJ0123456', 'RESIDENCE_CARD', 'CUSTOMER_PM', 'Mr.'),
(11, '1980-11-11', 'email11@example.com', '123-456-7890', 'Entertainment', 'REG123456', 'Company Eleven', 'United States', '123-456-7891', 'Emily', '123-456-7892', 'Davis', 'LLC', 'Divorced', 'American', 'Actor', 'emily.davis@example.com', '109-765-4321', '2035-11-11', 'JK1234567', 'CIN', 'CUSTOMER_PP', 'Ms.');
