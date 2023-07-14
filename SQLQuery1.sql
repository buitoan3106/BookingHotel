USE [DB_Hotel]
GO

/****** Object:  Table [dbo].[Users]    Script Date: 13/03/2023 4:54:26 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Users](
	[account] [varchar](30) NOT NULL,
	[password] [varchar](30) NULL,
	[name] [nvarchar](50) NULL,
	[phone number] [varchar](10) NULL,
	[id] [varchar](12) NULL,
	[address] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

create table Rooms(
room_id int primary key,
name varchar(30),
[type] int foreign key references Room_type,
[description] varchar(30),
price int
)

create table Room_type(
[type_id] int primary key,
name varchar(30)
)

create table Reservations(
reservation_id int primary key identity(1,1),
guest_id varchar(30) foreign key references Users,
room_id int foreign key references Rooms,
[start_date] date,
[end_date] date,
total_price int
)

insert into Room_type values (1, 'Single'),
							 (2, 'Double'),
							 (3, 'Vip')

insert into Rooms values (101, 'Single-1', 1, 'don-1.png', 299000),
						 (102, 'Single-2', 1, 'don-2.png', 299000),
						 (103, 'Single-3', 1, 'don-3.png', 299000),
						 (104, 'Single-4', 1, 'don-4.png', 299000),
						 (105, 'Single-5', 1, 'don-5.png', 299000),
						 (201, 'Double-1', 2, 'doi-1.png', 599000),
						 (202, 'Double-2', 2, 'doi-2.png', 599000),
						 (203, 'Double-3', 2, 'doi-3.png', 599000),
						 (204, 'Double-4', 2, 'doi-4.png', 599000),
						 (205, 'Double-5', 2, 'doi-5.png', 599000),
						 (301, 'Vip-1', 3, 'vip-1.png', 999000),
						 (302, 'Vip-2', 3, 'vip-2.png', 999000),
						 (303, 'Vip-3', 3, 'vip-3.png', 999000),
						 (304, 'Vip-4', 3, 'vip-4.png', 999000),
						 (305, 'Vip-5', 3, 'vip-5.png', 999000)

insert into Reservations(guest_id, room_id, [start_date], [end_date], total_price) 
values ('admin', 201, '2023-04-30', '2023-05-04', (select datediff(day, '2023-04-30', '2023-05-04'))*(select price from Rooms where room_id=201))