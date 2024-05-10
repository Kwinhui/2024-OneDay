CREATE DATABASE gallerydb3;
USE gallerydb3;

CREATE TABLE tbl_gallery(
g_email	VARCHAR(125)	PRIMARY KEY,
g_password	VARCHAR(125)	NOT NULL,
g_author	VARCHAR(125)	NOT NULL,
g_title	VARCHAR(125)	NOT NULL,
g_content	VARCHAR(125)	NOT NULL,
g_date	VARCHAR(10)	NOT NULL,
g_time	VARCHAR(10)	NOT NULL,
g_origin_image	VARCHAR(255)	NOT NULL,
g_up_image	VARCHAR(255)	NOT NULL
);

CREATE TABLE tbl_images (
i_seq	VARCHAR(125)	PRIMARY KEY,
i_gemail	VARCHAR(125)	NOT NULL,
i_origin_image	VARCHAR(255)	NOT NULL,
i_up_image	VARCHAR(255)	NOT NULL,
CONSTRAINT FK_GALLERY
FOREIGN KEY (i_gemail) 
REFERENCES tbl_gallery(g_email) ON DELETE CASCADE

);
SELECT * FROM tbl_gallery;
SELECT * FROM tbl_images;

DROP TABLE tbl_images;
DROP TABLE tbl_gallery;
