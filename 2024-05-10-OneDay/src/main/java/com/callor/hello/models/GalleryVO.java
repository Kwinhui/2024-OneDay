package com.callor.hello.models;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GalleryVO {
	private String g_email; //	VARCHAR(125)	PRIMARY KEY,
	private String 	g_password; //	VARCHAR(125)	NOT NULL,
	private String g_author; //	VARCHAR(125)	NOT NULL,
	private String g_title; //	VARCHAR(125)	NOT NULL,
	private String g_content; //	VARCHAR(125)	NOT NULL,
	private String 	g_date; //	VARCHAR(10)	NOT NULL,
	private String g_time; //	VARCHAR(10)	NOT NULL,
	private String g_origin_image; //	VARCHAR(255)	NOT NULL,
	private String g_up_image; //	VARCHAR(255)	NOT NULL

}
