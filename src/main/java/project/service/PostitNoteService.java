package project.service;

import java.util.List;

import project.model.UserInfoModel;

public interface PostitNoteService {

    /**
     * Save a {@link UserInfoModel}
     * @param postitNote {@link UserInfoModel} to be saved
     * @return {@link UserInfoModel} that was saved
     */
    UserInfoModel save(UserInfoModel postitNote);

    /**
     * Delete {@link UserInfoModel}
     * @param postitNote {@link UserInfoModel} to be deleted
     */
    void delete(UserInfoModel postitNote);

    /**
     * Get all {@link UserInfoModel}s
     * @return A list of {@link UserInfoModel}s
     */
    List<UserInfoModel> findAll();

    /**
     * Get all {@link UserInfoModel}s in a reverse order
     * @return A reversed list of {@link UserInfoModel}s
     */
    List<UserInfoModel> findAllReverseOrder();

    /**
     * Find a {@link UserInfoModel} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link UserInfoModel} with {@link Long id}
     */
    UserInfoModel findOne(Long id);

    /**
     * Find all {@link UserInfoModel}s with {@link String name}
     * @param name {@link String}
     * @return All {@link UserInfoModel}s with the {@link String name} passed
     */
    List<UserInfoModel> findByName(String name);

}
