<?xml version="1.0"?> <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/entries">
		<entries>
			<xsl:apply-templates/>
		</entries>
	</xsl:template>
	<xsl:template match="/entries/entry">
		<entry field="{field}"/>
	</xsl:template>
</xsl:stylesheet>