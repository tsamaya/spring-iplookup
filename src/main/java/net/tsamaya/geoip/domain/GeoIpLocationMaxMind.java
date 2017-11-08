package net.tsamaya.geoip.domain;

public class GeoIpLocationMaxMind implements GeoIpLocation {
	private String name;
	private String isoCode2;
	private Integer geoNameId;
	private String ipv4;

	public GeoIpLocationMaxMind(String name, String isoCode2, Integer geoNameId, String ipv4) {
		this.name = name;
		this.isoCode2 = isoCode2;
		this.geoNameId = geoNameId;
		this.ipv4 = ipv4;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getIsoCode2() {
		return isoCode2;
	}

	public Integer getGeoNameId() {
		return geoNameId;
	}

	public String getIpv4() {
		return ipv4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geoNameId == null) ? 0 : geoNameId.hashCode());
		result = prime * result + ((ipv4 == null) ? 0 : ipv4.hashCode());
		result = prime * result + ((isoCode2 == null) ? 0 : isoCode2.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoIpLocationMaxMind other = (GeoIpLocationMaxMind) obj;
		if (geoNameId == null) {
			if (other.geoNameId != null)
				return false;
		} else if (!geoNameId.equals(other.geoNameId))
			return false;
		if (ipv4 == null) {
			if (other.ipv4 != null)
				return false;
		} else if (!ipv4.equals(other.ipv4))
			return false;
		if (isoCode2 == null) {
			if (other.isoCode2 != null)
				return false;
		} else if (!isoCode2.equals(other.isoCode2))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeoIpLocationMaxMind [name=" + name + ", isoCode2=" + isoCode2 + ", geoNameId=" + geoNameId + ", ipv4="
				+ ipv4 + "]";
	}
}
