USE [master]
GO
/****** Object:  Database [MotorcycleManagement]    Script Date: 5/27/2021 8:17:16 AM ******/
CREATE DATABASE [MotorcycleManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MotorcycleManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MotorcycleManagement.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MotorcycleManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MotorcycleManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MotorcycleManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MotorcycleManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MotorcycleManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET  MULTI_USER 
GO
ALTER DATABASE [MotorcycleManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MotorcycleManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MotorcycleManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MotorcycleManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [MotorcycleManagement]
GO
/****** Object:  Table [dbo].[TblBike]    Script Date: 5/27/2021 8:17:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBike](
	[motocycleID] [varchar](10) NOT NULL,
	[model] [nvarchar](50) NOT NULL,
	[year] [datetime] NOT NULL,
	[condition] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[warranty] [nvarchar](50) NOT NULL,
	[brandID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_TblBike] PRIMARY KEY CLUSTERED 
(
	[motocycleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblBrand]    Script Date: 5/27/2021 8:17:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBrand](
	[brandID] [varchar](10) NOT NULL,
	[brandName] [nvarchar](50) NOT NULL,
	[country] [nvarchar](50) NOT NULL,
	[description] [nvarchar](200) NULL,
 CONSTRAINT [PK_TblBrand] PRIMARY KEY CLUSTERED 
(
	[brandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblUser]    Script Date: 5/27/2021 8:17:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblUser](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_TblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[TblBike]  WITH CHECK ADD  CONSTRAINT [FK_TblBike_TblBrand] FOREIGN KEY([brandID])
REFERENCES [dbo].[TblBrand] ([brandID])
GO
ALTER TABLE [dbo].[TblBike] CHECK CONSTRAINT [FK_TblBike_TblBrand]
GO
USE [master]
GO
ALTER DATABASE [MotorcycleManagement] SET  READ_WRITE 
GO
