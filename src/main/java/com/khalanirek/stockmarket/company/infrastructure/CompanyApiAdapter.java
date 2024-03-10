package com.khalanirek.stockmarket.company.infrastructure;

import com.khalanirek.stockmarket.company.dto.CompanyApi;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import lombok.experimental.UtilityClass;

import java.util.Comparator;

@UtilityClass
public class CompanyApiAdapter {

    public static class ApiToDto {

        public static CompanyDto.RegisterCompany toRegisterCompany(CompanyApi.RegisterCompanyRequest request) {
            return CompanyDto.RegisterCompany.builder()
                    .name(request.getName())
                    .symbol(request.getSymbol())
                    .shareCapital(request.getShareCapital())
                    .sharesQuantity(request.getSharesQuantity())
                    .build();
        }

    }


    public static class DtoToApi {

        public static CompanyApi.CompanyDetails toCompanyDetails(CompanyDto.Company dto) {
            return CompanyApi.CompanyDetails.builder()
                    .id(dto.getId().getId())
                    .name(dto.getName())
                    .symbol(dto.getSymbol())
                    .shareCapital(dto.getShareCapital())
                    .sharesQuantity(dto.getSharesQuantity())
                    .shares(dto.getShares().stream()
                            .map(DtoToApi::toShare)
                            .sorted(Comparator.comparing(CompanyApi.CompanyDetails.Share::getQuantity))
                            .toList())
                    .build();
        }

        public static CompanyApi.CompanyDetails.Share toShare(CompanyDto.Company.Share dto) {
            return CompanyApi.CompanyDetails.Share.builder()
                    .owner(toOwner(dto.getOwner()))
                    .quantity(dto.getQuantity())
                    .build();
        }

        public static CompanyApi.CompanyDetails.Share.Owner toOwner(CompanyDto.Company.Share.Owner dto) {
            return CompanyApi.CompanyDetails.Share.Owner.builder()
                    .ownerId(dto.getOwnerId())
                    .ownerType(dto.getOwnerType())
                    .build();
        }

    }

}
