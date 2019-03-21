package com.tr.domain;

import javax.persistence.*;

@Entity
@Table(name = "DataSet", schema = "MyTest")
public class Shoe {
    private int sid;
    private String asins;
    private String brand;
    private String categories;
    private String colors;
    private String count;
    private String dateAdded;
    private String dateUpdated;
    private String descriptions;
    private String dimension;
    private String ean;
    private String features;
    private String imageUrLs;
    private String kes;
    private String manufacturer;
    private String manufacturerNumber;
    private String merchants;
    private String name;
    private Double pricesAmountMin;
    private Double pricesAmountMax;
    private String pricesCondition;
    private String pricesCurrency;
    private String pricesIsSale;
    private String pricesMerchant;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "asins")
    public String getAsins() {
        return asins;
    }

    public void setAsins(String asins) {
        this.asins = asins;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "categories")
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Basic
    @Column(name = "colors")
    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    @Basic
    @Column(name = "count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Basic
    @Column(name = "date_added")
    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Basic
    @Column(name = "date_updated")
    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Basic
    @Column(name = "descriptions")
    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Basic
    @Column(name = "dimension")
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Basic
    @Column(name = "ean")
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    @Basic
    @Column(name = "features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Basic
    @Column(name = "imageURLs")
    public String getImageUrLs() {
        return imageUrLs;
    }

    public void setImageUrLs(String imageUrLs) {
        this.imageUrLs = imageUrLs;
    }

    @Basic
    @Column(name = "kes")
    public String getKes() {
        return kes;
    }

    public void setKes(String kes) {
        this.kes = kes;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "manufacturer_number")
    public String getManufacturerNumber() {
        return manufacturerNumber;
    }

    public void setManufacturerNumber(String manufacturerNumber) {
        this.manufacturerNumber = manufacturerNumber;
    }

    @Basic
    @Column(name = "merchants")
    public String getMerchants() {
        return merchants;
    }

    public void setMerchants(String merchants) {
        this.merchants = merchants;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "prices_amount_min")
    public Double getPricesAmountMin() {
        return pricesAmountMin;
    }

    public void setPricesAmountMin(Double pricesAmountMin) {
        this.pricesAmountMin = pricesAmountMin;
    }

    @Basic
    @Column(name = "prices_amount_max")
    public Double getPricesAmountMax() {
        return pricesAmountMax;
    }

    public void setPricesAmountMax(Double pricesAmountMax) {
        this.pricesAmountMax = pricesAmountMax;
    }

    @Basic
    @Column(name = "prices_condition")
    public String getPricesCondition() {
        return pricesCondition;
    }

    public void setPricesCondition(String pricesCondition) {
        this.pricesCondition = pricesCondition;
    }

    @Basic
    @Column(name = "prices_currency")
    public String getPricesCurrency() {
        return pricesCurrency;
    }

    public void setPricesCurrency(String pricesCurrency) {
        this.pricesCurrency = pricesCurrency;
    }

    @Basic
    @Column(name = "prices_is_sale")
    public String getPricesIsSale() {
        return pricesIsSale;
    }

    public void setPricesIsSale(String pricesIsSale) {
        this.pricesIsSale = pricesIsSale;
    }

    @Basic
    @Column(name = "prices_merchant")
    public String getPricesMerchant() {
        return pricesMerchant;
    }

    public void setPricesMerchant(String pricesMerchant) {
        this.pricesMerchant = pricesMerchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shoe that = (Shoe) o;

        if (sid != that.sid) return false;
        if (asins != null ? !asins.equals(that.asins) : that.asins != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (colors != null ? !colors.equals(that.colors) : that.colors != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (dateAdded != null ? !dateAdded.equals(that.dateAdded) : that.dateAdded != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (descriptions != null ? !descriptions.equals(that.descriptions) : that.descriptions != null) return false;
        if (dimension != null ? !dimension.equals(that.dimension) : that.dimension != null) return false;
        if (ean != null ? !ean.equals(that.ean) : that.ean != null) return false;
        if (features != null ? !features.equals(that.features) : that.features != null) return false;
        if (imageUrLs != null ? !imageUrLs.equals(that.imageUrLs) : that.imageUrLs != null) return false;
        if (kes != null ? !kes.equals(that.kes) : that.kes != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (manufacturerNumber != null ? !manufacturerNumber.equals(that.manufacturerNumber) : that.manufacturerNumber != null)
            return false;
        if (merchants != null ? !merchants.equals(that.merchants) : that.merchants != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pricesAmountMin != null ? !pricesAmountMin.equals(that.pricesAmountMin) : that.pricesAmountMin != null)
            return false;
        if (pricesAmountMax != null ? !pricesAmountMax.equals(that.pricesAmountMax) : that.pricesAmountMax != null)
            return false;
        if (pricesCondition != null ? !pricesCondition.equals(that.pricesCondition) : that.pricesCondition != null)
            return false;
        if (pricesCurrency != null ? !pricesCurrency.equals(that.pricesCurrency) : that.pricesCurrency != null)
            return false;
        if (pricesIsSale != null ? !pricesIsSale.equals(that.pricesIsSale) : that.pricesIsSale != null) return false;
        if (pricesMerchant != null ? !pricesMerchant.equals(that.pricesMerchant) : that.pricesMerchant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (asins != null ? asins.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (colors != null ? colors.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
        result = 31 * result + (ean != null ? ean.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        result = 31 * result + (imageUrLs != null ? imageUrLs.hashCode() : 0);
        result = 31 * result + (kes != null ? kes.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (manufacturerNumber != null ? manufacturerNumber.hashCode() : 0);
        result = 31 * result + (merchants != null ? merchants.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pricesAmountMin != null ? pricesAmountMin.hashCode() : 0);
        result = 31 * result + (pricesAmountMax != null ? pricesAmountMax.hashCode() : 0);
        result = 31 * result + (pricesCondition != null ? pricesCondition.hashCode() : 0);
        result = 31 * result + (pricesCurrency != null ? pricesCurrency.hashCode() : 0);
        result = 31 * result + (pricesIsSale != null ? pricesIsSale.hashCode() : 0);
        result = 31 * result + (pricesMerchant != null ? pricesMerchant.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.brand+"||"+this.sid;
    }
}
