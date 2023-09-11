package com.example.demo.domain.user.service;

import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryMyInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyInfoResponse queryMyInfo() {
        return new QueryMyInfoResponse(userFacade.getCurrentUser());
    }
}
