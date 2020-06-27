package com.mishiranu.dashchan.chan.diochan;

import chan.content.ChanConfiguration;

public class DiochanChanConfiguration extends ChanConfiguration {
	//TODO set config for DioChan (based on the old extension's DiochanChanConfiguration class if config hasn't changed - unlikely)
	public DiochanChanConfiguration() {
		request(OPTION_READ_POSTS_COUNT);
		setDefaultName("Anonymous");
	}

	@Override
	public Board obtainBoardConfiguration(String boardName) {
		Board board = new Board();
		board.allowCatalog = true;
		board.allowPosting = true;
		board.allowDeleting = true;
		board.allowReporting = true;
		return board;
	}

	@Override
	public Posting obtainPostingConfiguration(String boardName, boolean newThread) {
		Posting posting = new Posting();
		boolean namesAndEmails = !"layer".equals(boardName);
		posting.allowName = namesAndEmails;
		posting.allowTripcode = namesAndEmails;
		posting.allowEmail = namesAndEmails;
		posting.allowSubject = true;
		posting.allowEmbed = true;
		posting.optionSage = namesAndEmails;
		posting.attachmentCount = 3;
		posting.attachmentMimeTypes.add("image/*");
		posting.attachmentSpoiler = true;
		return posting;
	}

	@Override
	public Deleting obtainDeletingConfiguration(String boardName) {
		Deleting deleting = new Deleting();
		deleting.password = true;
		deleting.multiplePosts = true;
		deleting.optionFilesOnly = true;
		return deleting;
	}

	@Override
	public Reporting obtainReportingConfiguration(String boardName) {
		Reporting reporting = new Reporting();
		reporting.comment = true;
		reporting.multiplePosts = true;
		return reporting;
	}
}