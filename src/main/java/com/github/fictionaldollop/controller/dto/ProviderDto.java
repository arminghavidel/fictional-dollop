package com.github.fictionaldollop.controller.dto;

import com.github.fictionaldollop.domain.Provider;

public class ProviderDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProviderDto map(Provider provider){
        var providerDto = new ProviderDto();
        providerDto.setId(provider.getId());
        providerDto.setName(provider.getName());
        return providerDto;
    }
}
